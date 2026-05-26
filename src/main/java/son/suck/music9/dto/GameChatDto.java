package son.suck.music9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameChatDto {
    private Long roomId;       // 어느 방에서 친 채팅인지
    private Long userId;       // 누가 쳤는지
    private Long musicId;      // 현재 나오고 있는 노래가 뭔지
    private String userChat;
}
