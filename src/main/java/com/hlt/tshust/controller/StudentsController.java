package com.hlt.tshust.controller;

import com.hlt.tshust.dto.students.StudentsRequest;
import com.hlt.tshust.model.Students;
import com.hlt.tshust.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    // Đường dẫn đến thư mục upload
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/upload/";

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdateStudent(
            @RequestPart("student") StudentsRequest studentRequest,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "idFront", required = false) MultipartFile idFront,
            @RequestPart(value = "idBack", required = false) MultipartFile idBack) throws IOException {

        // Lưu ảnh vào thư mục static/upload
        if (photo != null && !photo.isEmpty()) {
            String photoUrl = saveFile(photo);
            studentRequest.setPhotoUrl(photoUrl);
        }

        if (idFront != null && !idFront.isEmpty()) {
            String idFrontUrl = saveFile(idFront);
            studentRequest.setIdCardFrontUrl(idFrontUrl);
        }

        if (idBack != null && !idBack.isEmpty()) {
            String idBackUrl = saveFile(idBack);
            studentRequest.setIdCardBackUrl(idBackUrl);
        }

        studentsService.saveOrUpdateStudent(studentRequest);
        return "Student information has been saved/updated successfully.";
    }

    // Hàm lưu file vào thư mục upload và trả về đường dẫn của file
    private String saveFile(MultipartFile file) throws IOException {
        // Kiểm tra nếu thư mục upload chưa tồn tại thì tạo mới
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Lưu file vào thư mục upload
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR, fileName);
        Files.write(filePath, file.getBytes());

        // Trả về đường dẫn tương đối để lưu vào cơ sở dữ liệu
        return "/upload/" + fileName;
    }
}
