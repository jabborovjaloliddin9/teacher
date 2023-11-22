package uz.online.teacher.service;

import org.springframework.web.multipart.MultipartFile;
import uz.online.teacher.entity.FileItem;

import java.io.IOException;

public interface FileItemService {
    String upload(MultipartFile file) throws IOException;

    FileItem getFile(String uid);

    void delete(String uid);
}
