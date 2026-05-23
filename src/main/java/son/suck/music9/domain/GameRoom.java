package son.suck.music9.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class GameRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    private User host;

    // 🔥 핵심 리팩토링 포인트: 단일 문자열에서 1:N 형태의 값 타입 컬렉션으로 변경!
    // DB에는 자동으로 'game_room_genres'라는 매핑 테이블이 만들어지며 한 방에 여러 장르가 저장됩니다.
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "game_room_genres", joinColumns = @JoinColumn(name = "game_room_id"))
    @Column(name = "genre_name", length = 50)
    private List<String> selectedGenres = new ArrayList<>();

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "max_song_count", nullable = false)
    private Integer maxSongCount;

    @Column(name = "is_playing", nullable = false)
    private Boolean isPlaying;

    @Builder
    public GameRoom(String title, User host, List<String> selectedGenres, Integer startYear, Integer endYear, Integer maxSongCount) {
        this.title = title;
        this.host = host;
        // null 방지를 위한 안전장치 처리
        this.selectedGenres = selectedGenres != null ? selectedGenres : new ArrayList<>();
        this.startYear = startYear;
        this.endYear = endYear;
        this.maxSongCount = maxSongCount;
        this.isPlaying = false;
    }

    public void startSpecification() {
        this.isPlaying = true;
    }
    public void endSpecification() {
        this.isPlaying = false;
    }
}
