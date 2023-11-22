package uz.online.teacher.entity.cache;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import uz.online.teacher.entity.User;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(timeToLive = 60 * 60 * 24)
public class RefreshToken {
    @Id
    private String refreshToken;
    private User user;
}
