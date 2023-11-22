package uz.online.teacher.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.online.teacher.entity.FileItem;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.FileItemRepository;
import uz.online.teacher.service.FileItemService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileItemServiceImpl implements FileItemService {

    private final FileItemRepository repository;

    @PostConstruct
    private void init() throws IOException {
        File file = new File("./files");
        file.mkdirs();
    }

    @Override
    public String upload(MultipartFile file) throws IOException {
        String uid = UUID.randomUUID().toString().replace("-", "").trim();
        String fileName = uid + file.getOriginalFilename();
        Path path = Path.of(".\\files" + "\\" + fileName);
        Files.copy(file.getInputStream(), path);
        FileItem fileForEntity = FileItem.builder()
                .originalName(file.getOriginalFilename())
                .uid(uid)
                .name(fileName)
                .fileSize(file.getSize() / 1024)
                .extension(file.getOriginalFilename().split("\\.")[1])
                .contentType(file.getContentType())
                .uid(uid)
                .url(Paths.get("").toAbsolutePath() + "\\files\\" + fileName)
                .build();
        repository.save(fileForEntity);
        return uid;
    }

    @Override
    public FileItem getFile(String uid) {
        return repository.findByUidAndDeletedFalse(uid).orElseThrow(() -> new ObjectNotFoundException(uid, "file"));
    }

    @Override
    public void delete(String uid) {
        FileItem fileItem = getFile(uid);
        File file = new File(fileItem.getUrl());
        if (file.delete()) {
            fileItem.setDeleted(true);
            repository.save(fileItem);
        }
    }

    public List<FileItem> getFiles(List<String> uids) {
        return repository.findByUids(uids);
    }
}
