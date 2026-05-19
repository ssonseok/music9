package son.suck.music9.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "genre_filter", length = 50)
    private String genreFilter;

    @Column(name = "year_filter", length = 50)
    private String yearFilter;

    @Column(name = "max_song_count", nullable = false)
    private Integer maxSongCount;

    @Column(name = "is_playing", nullable = false)
    private Boolean isPlaying;


    @Builder
    public GameRoom(String title, User host, String genreFilter, String yearFilter, Integer maxSongCount) {
        this.title = title;
        this.host = host;
        this.genreFilter = genreFilter;
        this.yearFilter = yearFilter;
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
