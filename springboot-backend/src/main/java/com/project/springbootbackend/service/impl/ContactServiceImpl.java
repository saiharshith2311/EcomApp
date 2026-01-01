package com.project.springbootbackend.service.impl;

import com.project.springbootbackend.constants.ApplicationConstants;
import com.project.springbootbackend.dto.ContactRequestDto;
import com.project.springbootbackend.dto.ContactResponseDto;
import com.project.springbootbackend.exception.ResourceNotFoundException;
import com.project.springbootbackend.repository.ContactRepository;
import com.project.springbootbackend.service.IContactService;
import  com.project.springbootbackend.entity.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {
    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {

            Contact contact =transformToEntity(contactRequestDto);

            contactRepository.save(contact);
            return true;



    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setStatus(ApplicationConstants.OPEN_MESSAGE);

        return contact;

    }

    @Override
    public List<ContactResponseDto> getAllOpenMessages() {
        List<Contact> contacts = contactRepository.findByStatus(ApplicationConstants.OPEN_MESSAGE);
        return contacts.stream().map(this::mapToContactResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void updateMessageStatus(Long contactId, String status) {
        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact", "ContactID", contactId.toString())
        );
        contact.setStatus(status);
        contactRepository.save(contact);

    }
    private ContactResponseDto mapToContactResponseDTO(Contact contact) {
        ContactResponseDto responseDTO = new ContactResponseDto(
                contact.getContactId(),
                contact.getName(),
                contact.getEmail(),
                contact.getMobileNumber(),
                contact.getMessage(),
                contact.getStatus()
        );
        return responseDTO;
    }

}
