package com.example.demo.Controller;

import com.example.demo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class FileUploadDownloadController {

    /**
     * 处理文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        // 处理文件上传逻辑
        final String UPLOAD_DIR = "C:\\Users\\18305\\Desktop\\download";
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
    /**
     * 查看文件
     */
    @GetMapping("/download")
    public Result<List<String>> getAllFile() throws IOException {
        String uploadDirectory = "C:\\Users\\18305\\Desktop\\download";

        // 创建File对象
        File directory = new File(uploadDirectory);

        // 获取目录下所有文件
        File[] files = directory.listFiles();
        List<String> fileList = new ArrayList<>();
        // 打印文件列表
        if (files != null) {
            for (File file : files) {
                fileList.add(file.getName());
            }
        }
        return Result.success(fileList);
    }
    /**
     * 处理文件下载
     * @param fileName
     * @return
     * @throws IOException
     */
    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        // 构建文件路径
        final String FILE_DIRECTORY = "C:\\Users\\18305\\Desktop\\download";
        Path filePath = Paths.get(FILE_DIRECTORY).resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());

        // 检查文件是否存在
        if (resource.exists() || resource.isReadable()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())
                    .body(resource);
        } else {
            // 文件不存在
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
