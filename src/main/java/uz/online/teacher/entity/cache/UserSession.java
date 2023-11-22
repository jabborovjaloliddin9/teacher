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
@RedisHash(timeToLive = 60 * 60 * 3)
public class UserSession {
    @Id
    private String sessionId;
    private User user;
}
