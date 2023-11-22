package uz.online.teacher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.online.teacher.entity.FileItem;
import uz.online.teacher.service.impl.FileItemServiceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

@RestController
@RequiredArgsConstructor
@RequestMapping("file")
public class FileItemController {

    private final FileItemServiceImpl service;

    @PostMapping
    public String update(@RequestParam MultipartFile file) throws IOException {
        return service.upload(file);
    }

    @GetMapping
    public ResponseEntity<Resource> prewiev(@RequestParam String uid) throws MalformedURLException {
        FileItem fileItem = service.getFile(uid.replace(",", ""));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; fileName=\"" + URLEncoder.encode(fileItem.getName()))
                .contentType(MediaType.parseMediaType(fileItem.getContentType()))
                .body(new FileUrlResource(fileItem.getUrl()));
    }

    @GetMapping("download")
    public ResponseEntity<Resource> download(@RequestParam String uid) throws MalformedURLException {
        FileItem fileItem = service.getFile(uid);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + URLEncoder.encode(fileItem.getName()))
                .contentType(MediaType.parseMediaType(fileItem.getContentType()))
                .body(new FileUrlResource(fileItem.getUrl()));
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam String uid) {
        service.delete(uid);
    }
}
