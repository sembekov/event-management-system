package org.example.eventmanager.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class RegistrationController {

    @PostMapping("/register")
    public ResponseEntity<?> registerParticipant(@RequestPart("firstName") String firstName,
                                                 @RequestPart("lastName") String lastName,
                                                 @RequestPart("email") String email,
                                                 @RequestPart("password") String password,
                                                 @RequestPart("profileImage") MultipartFile profileImage) {
        // Обработка данных и регистрация
        return ResponseEntity.ok("Registration successful");
    }
}
