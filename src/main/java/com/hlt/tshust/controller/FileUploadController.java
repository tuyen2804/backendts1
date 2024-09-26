package com.hlt.tshust.controller;

import com.hlt.tshust.dto.ImageRequest;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final String uploadDir = "src/main/resources/static/upload/";

    @PostMapping("/uploadBase64")
    public String uploadBase64Image(@RequestBody ImageRequest imageRequest) {
        // Nhận dữ liệu Base64 từ request
        String base64Data = imageRequest.getImage();
        if (base64Data == null || base64Data.isEmpty()) {
            return "Không có dữ liệu ảnh được gửi.";
        }

        // Chuyển đổi Base64 thành dữ liệu nhị phân
        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);

        // Đặt tên file với thời gian hiện tại
        String fileName = "uploaded_image_" + System.currentTimeMillis() + ".jpg";

        // Lưu file ảnh vào thư mục
        File outputFile = new File(uploadDir + fileName);
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(decodedBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Trả về thông báo thành công
        return "File saved successfully as: /static/upload/" + fileName;
    }
}

