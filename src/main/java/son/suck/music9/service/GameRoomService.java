package son.suck.music9.service;

import son.suck.music9.domain.GameRoom;
import son.suck.music9.dto.GameRoomCreateDto;

import java.util.List;

public interface GameRoomService {
    // 1. 방 만들기 (방 제목, 방장 ID, 장르 리스트, 시작 연도, 끝 연도, 총 문제 수)
    GameRoom createRoom(GameRoomCreateDto dto);

    // 2. 대기실에 보여줄 "게임 중이 아닌" 방 목록 조회
    List<GameRoom> getWaitRooms();

    // 3. 특정 방 입장 또는 방 정보 상세 조회
    GameRoom getRoomById(Long roomId);

    // 4. 방 폭파 (방장이 대기방에서 나갔을 때)
    void deleteRoom(Long roomId);
}
