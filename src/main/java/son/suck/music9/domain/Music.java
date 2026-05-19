package son.suck.music9.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "youtube_id", nullable = false, unique = true, length = 50)
    private String youtubeId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String artist;

    @Column(length = 50)
    private String genre;

    @Column(name = "release_year")
    private Integer releaseYear;

    // 💡 양방향 매핑: mappedBy의 "music"은 자식(MusicAnswer) 클래스에 적은 필드명과 일치해야 합니다.
    // cascade = CascadeType.ALL을 주면 노래를 지울 때 매칭된 정답들도 한 번에 싹 지워집니다.
//    @OneToMany(mappedBy = "music", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<MusicAnswer> answers = new ArrayList<>();

    @Builder
    public Music(String youtubeId, String title, String artist, String genre, Integer releaseYear) {
        this.youtubeId = youtubeId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
