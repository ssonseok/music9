package son.suck.music9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameSkipDto {
    private Long roomId;
    private Long userId;
    private Long currentMusicId;
}
