package com.project.springbootbackend.controller;


import com.project.springbootbackend.dto.ContactInfoDto;
import com.project.springbootbackend.dto.ContactRequestDto;
import com.project.springbootbackend.dto.ProductDto;
import com.project.springbootbackend.service.IContactService;
import com.project.springbootbackend.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    private final IContactService iContactService;
    private final ContactInfoDto contactInfoDto;

    @PostMapping
    public ResponseEntity<String> saveContact(@Valid @RequestBody ContactRequestDto contactRequestDto)  {


         iContactService.saveContact(contactRequestDto);

            return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");

    }

    @GetMapping
    public ResponseEntity<ContactInfoDto> getContactInfo(){
        return ResponseEntity.ok(contactInfoDto);
    }
}
