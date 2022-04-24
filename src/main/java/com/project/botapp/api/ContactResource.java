package com.project.botapp.api;


import com.project.botapp.models.Contact;
import com.project.botapp.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ContactResource {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getContacts(){
        return ResponseEntity.ok(contactService.getContacts());
    }

    @PostMapping("/contact/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/contact/add").toUriString());
        return ResponseEntity.created(uri).body(contactService.saveContact(contact));
    }
}
