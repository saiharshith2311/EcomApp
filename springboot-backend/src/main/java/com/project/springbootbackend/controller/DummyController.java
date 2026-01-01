package com.project.springbootbackend.controller;


import com.project.springbootbackend.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/dummy")
public class DummyController {

    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return "User created successfully";

    }
    @GetMapping("/search")
    public String searchUser(@RequestParam String name){

        return "searching for user"+name;

    }
    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable String userId){

        return "searching for user"+userId;

    }
}
