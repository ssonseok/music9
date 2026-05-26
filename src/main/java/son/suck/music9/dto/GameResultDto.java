package son.suck.music9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameResultDto {
    private Long roomId;                // 종료된 방 ID
    private List<UserScoreDto> rankings; // 1등부터 꼴등까지 순서대로 정렬된 리스트

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserScoreDto {
        private Long userId;     // 유저 식별 ID
        private String nickname; // 화면에 "C님 우승" 이라고 이름을 찍어주기 위한 닉네임
        private Integer score;   // 이 유저가 획득한 최종 점수
    }
}
