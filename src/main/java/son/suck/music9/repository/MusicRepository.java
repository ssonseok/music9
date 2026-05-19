package son.suck.music9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import son.suck.music9.domain.Music;

import java.util.List;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {
    // 방에 설정된 연도(releaseYear)의 노래만 DB에서 랜덤으로 N개 가져오기
    // 선택한 여러 장르(IN) + 연도 범위(BETWEEN) 조건으로 랜덤 N개 추출
    @Query(value = "SELECT * FROM music " +
            "WHERE genre IN (:genres) " +
            "AND release_year BETWEEN :startYear AND :endYear " +
            "ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Music> findRandomMusicByFilters(
            @Param("genres") List<String> genres,  // ["댄스", "발라드", "힙합"] 형태로 전달
            @Param("startYear") Integer startYear,
            @Param("endYear") Integer endYear,
            @Param("count") int count
    );

    //채점 및 정답 조회를 위해 Music을 가져올 때 MusicAnswer 리스트까지 한 번에 가져오기 (N+1 문제 방지 Fetch Join)
    @Query("select m from Music m join fetch m.answers where m.id = :id")
    Optional<Music> findByIdWithAnswers(@Param("id") Long id);
}
