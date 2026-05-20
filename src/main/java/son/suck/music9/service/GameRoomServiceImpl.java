package son.suck.music9.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import son.suck.music9.domain.GameRoom;
import son.suck.music9.domain.User;
import son.suck.music9.repository.GameRoomRepository;
import son.suck.music9.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true) //읽기 전용 성능 최적화 기본 세팅
public class GameRoomServiceImpl implements GameRoomService{
    private final GameRoomRepository gameRoomRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public GameRoom createRoom(String title, Long hostId, List<String> genres, Integer startYear, Integer endYear, int maxSongCount) {
        // 방장(Host) 유저가 실제로 존재하는지 검증
//        User host = userRepository.findById(hostId)
//                .orElseThrow(() -> new IllegalArgumentException("방장 정보를 찾을 수 없습니다. 유저 ID: " + hostId));
//
//        // 빌더 패턴을 이용해 방 정보 조립
//        GameRoom gameRoom = GameRoom.builder()
//                .title(title)
//                .host(host)
//                .genreFilter(genres)
//                .startYear(startYear)
//                .endYear(endYear)
//                .maxSongCount(maxSongCount)
//                .isPlaying(false) // 방이 처음 만들어졌을 때는 당연히 대기 상태!
//                .build();
//
//        return gameRoomRepository.save(gameRoom);
        return null;
    }

    @Override
    public List<GameRoom> getWaitRooms() {
        return List.of();
    }

    @Override
    public GameRoom getRoomById(Long roomId) {
        return null;
    }

    @Override
    public void deleteRoom(Long roomId) {

    }
}
