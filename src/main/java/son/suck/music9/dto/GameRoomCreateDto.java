package son.suck.music9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameRoomCreateDto {
    private String title;
    private Long hostId;
    private List<String> selectedGenres;
    private Integer startYear;
    private Integer endYear;
    private Integer maxSongCount;
}
