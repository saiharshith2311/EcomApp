package com.project.springbootbackend.controller;


import com.project.springbootbackend.dto.ProfileRequestDto;
import com.project.springbootbackend.dto.ProfileResponseDto;
import com.project.springbootbackend.service.IProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final IProfileService iProfileService;

    @GetMapping
    public ResponseEntity<ProfileResponseDto> getProfile() {
        ProfileResponseDto profileResponseDto = iProfileService.getProfile();
        return ResponseEntity.ok().body(profileResponseDto);

    }
    @PutMapping
    public ResponseEntity<ProfileResponseDto> updateProfile(@Validated @RequestBody ProfileRequestDto profileRequestDto) {
      ProfileResponseDto profileResponseDto = iProfileService.updateProfile(profileRequestDto);
      return ResponseEntity.ok().body(profileResponseDto);
    }

}
