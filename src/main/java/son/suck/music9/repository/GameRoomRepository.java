package son.suck.music9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import son.suck.music9.domain.GameRoom;

import java.util.List;
import java.util.Optional;

public interface GameRoomRepository extends JpaRepository<GameRoom, Long> {
    List<GameRoom> findByIsPlayingFalse();

    //  방에 입장하거나 게임 시작할 때, 방장 정보(Host)까지 한방에 긁어오기
    @Query("select gr from GameRoom gr join fetch gr.host where gr.id = :id")
    Optional<GameRoom> findByIdWithHost(@Param("id") Long id);
}
