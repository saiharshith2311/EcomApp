package com.project.springbootbackend.service;

import com.project.springbootbackend.dto.ContactRequestDto;
import com.project.springbootbackend.dto.ContactResponseDto;
import com.project.springbootbackend.dto.ProductDto;

import java.util.List;

public interface IContactService {

    boolean saveContact(ContactRequestDto contactRequestDto);
    List<ContactResponseDto>  getAllOpenMessages();
    void updateMessageStatus(Long contactId, String status);
}
