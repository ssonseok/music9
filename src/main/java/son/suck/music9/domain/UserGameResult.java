package son.suck.music9.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@NoArgsConstructor
public class UserGameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_result_id", nullable = false)
    private GameResult gameResult;

    @Column(nullable = false)
    private Integer score;

    @Column(name = "is_winner", nullable = false)
    private Boolean isWinner;

    @Builder
    public UserGameResult(User user, GameResult gameResult, Integer score, Boolean isWinner) {
        this.user = user;
        this.gameResult = gameResult;
        this.score = score;
        this.isWinner = isWinner;
    }

    protected void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }
}
