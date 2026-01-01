package com.project.springbootbackend.service;

import com.project.springbootbackend.dto.ProfileRequestDto;
import com.project.springbootbackend.dto.ProfileResponseDto;
import org.springframework.context.annotation.Profile;

public interface IProfileService {
    ProfileResponseDto getProfile();
    ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}
