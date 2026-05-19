package son.suck.music9.service;

import son.suck.music9.domain.GameResult;
import son.suck.music9.domain.Music;

import java.util.List;
import java.util.Map;

public interface GamePlayService {
    // 1. 게임 시작! (방 옵션에 맞는 랜덤 노래 목록 퀴즈 싹 긁어오기)
    List<Music> startGame(Long roomId);

    // 2. 유저가 채팅 친 정답 실시간 검증 (맞으면 true, 틀리면 false)
    boolean checkAnswer(Long musicId, String userChat, Long userId);

    // 3. 문제 스킵 기능
    // 과반수 투표가 완료되었거나 방장이 스킵을 눌렀을 때, 다음 문제로 넘어가기 위한 정답 데이터를 반환하거나 상태를 확인합니다.
    // (예: 스킵된 노래의 정답이 뭐였는지 화면에 잠깐 보여주기 위해 정답 정보를 반환할 수도 있습니다.)
    Music skipCurrentSong(Long roomId, Long currentMusicId);

    // 4. 게임 완전히 종료 (웹소켓 메모리에 쌓인 {유저ID: 최종점수} 지도를 받아서 DB에 영구 저장)
    GameResult endGame(Long roomId, Map<Long, Integer> finalScores);
}
