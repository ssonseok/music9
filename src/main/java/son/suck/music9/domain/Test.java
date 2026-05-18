package son.suck.music9.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Test {
    @Id // 기본키(PK) 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 자동 증가 (1, 2, 3...)
    private Long test1;

    private String test2;  // 노래 제목 컬럼이 될 친구
    private String test3; // 가수 이름 컬럼이 될 친구
}
