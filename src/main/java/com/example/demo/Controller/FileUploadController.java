package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        // 处理文件上传逻辑
        final String UPLOAD_DIR = "C:\\Users\\18305\\Desktop\\pythonProject";
        // 可以保存文件到本地、存储到数据库等等
        if (file.isEmpty()) {
            System.out.println("Please select a file to upload.");
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        try {
            // 获取文件名
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            System.out.println(fileName);
            // 创建目录
            Path uploadPath = Paths.get(UPLOAD_DIR);
            Files.createDirectories(uploadPath);

            // 保存文件到目标路径
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            // 返回成功响应
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file.");
        }

    }
}
