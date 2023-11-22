package uz.online.teacher.entity.cache;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(timeToLive = 5 * 60)
public class EmailMessageCode {
    @Id
    private String sessionId;
    private String code;
}
