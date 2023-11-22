package uz.online.teacher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FileItem extends BaseEntity {
    @Column(length = 256, nullable = false)
    private String originalName;
    @Column(length = 128, nullable = false)
    private String uid;
    @Column(length = 128, nullable = false)
    private String name;
    @Column(length = 128, nullable = false)
    private Long fileSize;
    @Column(length = 32, nullable = false)
    private String extension;
    @Column(length = 32, nullable = false)
    private String contentType;
    @Column(length = 256, nullable = false)
    private String url;
}
