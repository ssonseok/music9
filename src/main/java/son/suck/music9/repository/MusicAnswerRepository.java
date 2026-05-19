package son.suck.music9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music9.domain.MusicAnswer;

public interface MusicAnswerRepository extends JpaRepository<MusicAnswer, Long> {
    boolean existsByMusicIdAndAnswerText(Long musicId, String userAnswer);
}
