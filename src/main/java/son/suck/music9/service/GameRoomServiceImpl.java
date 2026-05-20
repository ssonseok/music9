package son.suck.music9.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import son.suck.music9.domain.GameRoom;
import son.suck.music9.domain.User;
import son.suck.music9.dto.GameRoomCreateDto;
import son.suck.music9.repository.GameRoomRepository;
import son.suck.music9.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameRoomServiceImpl implements GameRoomService{
    private final GameRoomRepository gameRoomRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public GameRoom createRoom(GameRoomCreateDto dto) {
        User host = userRepository.findById(dto.getHostId())
                .orElseThrow(() -> new IllegalArgumentException("방장 정보를 찾을 수 없습니다. ID: " + dto.getHostId()));

        GameRoom gameRoom = GameRoom.builder()
                .title(dto.getTitle())
                .host(host)
                .genreFilter(dto.getGenreFilter())
                .startYear(dto.getStartYear())
                .endYear(dto.getEndYear())
                .maxSongCount(dto.getMaxSongCount())
                .build();

        return gameRoomRepository.save(gameRoom);
    }

    @Override
    public List<GameRoom> getWaitRooms() {
        return gameRoomRepository.findByIsPlayingFalse();
    }

    @Override
    public GameRoom getRoomById(Long roomId) {
        return gameRoomRepository.findByIdWithHost(roomId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 방입니다. ID: " + roomId));
    }

    @Override
    @Transactional
    public void deleteRoom(Long roomId) {
        GameRoom room = gameRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("삭제하려는 방이 존재하지 않습니다. ID: " + roomId));
        gameRoomRepository.delete(room);
    }
}
