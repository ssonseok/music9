package son.suck.music9.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_title", nullable = false, length = 100)
    private String roomTitle; // 플레이했던 방 제목 (기록용)

    @Column(name = "total_songs", nullable = false)
    private Integer totalSongs; // 총 진행 곡 수

    @Column(name = "played_at", nullable = false, updatable = false)
    private LocalDateTime playedAt; // 게임 종료 시간

    @OneToMany(mappedBy = "gameResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserGameResult> userGameResults = new ArrayList<>();

    @Builder
    public GameResult(String roomTitle, Integer totalSongs) {
        this.roomTitle = roomTitle;
        this.totalSongs = totalSongs;
        this.playedAt = LocalDateTime.now(); // 생성 시점 현재 시간 자동 저장
    }

    public void addUserGameResult(UserGameResult userGameResult) {
        this.userGameResults.add(userGameResult);
        if (userGameResult.getGameResult() != this) {
            userGameResult.setGameResult(this);
        }
    }
}
