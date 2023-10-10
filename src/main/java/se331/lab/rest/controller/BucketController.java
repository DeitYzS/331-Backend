package se331.lab.rest.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.rest.util.CloundStorageHelper;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloundStorageHelper cloundStorageHelper;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart (value = "file") MultipartFile file) throws IOException, ServletException {
        return ResponseEntity.ok(this.cloundStorageHelper.getImageUrl(file, "imageupload-2e148.appspot.com"));
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestPart (value = "image") MultipartFile file) throws IOException, ServletException {
        return ResponseEntity.ok(this.cloundStorageHelper.getStorageFileDto(file, "imageupload-2e148.appspot.com"));
    }
}
