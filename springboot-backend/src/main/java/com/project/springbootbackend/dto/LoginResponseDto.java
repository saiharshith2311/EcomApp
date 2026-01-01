package com.project.springbootbackend.dto;

public record LoginResponseDto(String message,UserDto user,String jwtToken) {
}
