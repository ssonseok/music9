package son.suck.music9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music9.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
