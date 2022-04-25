package com.project.botapp.api;


import com.project.botapp.models.Contact;
import com.project.botapp.models.Message;
import com.project.botapp.service.ContactService;
import javassist.NotFoundException;
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

    @PutMapping("/contact/edit")
    public ResponseEntity<Contact> editContact(@RequestBody Contact contact) throws NotFoundException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/contact/edit/").toUriString());
        return ResponseEntity.created(uri).body(contactService.editContact(contact, contact.getId()));
    }
    
    @PostMapping("/contact/message/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message,@RequestParam("id") Long id){
        URI uri  = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/contact/message/add").toUriString());
        contactService.addMessage(message,id);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/contact/messages")
    public ResponseEntity<List<Message>> getMessagesByContact(@RequestParam("id") Long id){
        return ResponseEntity.ok(contactService.getMessagesByContact(id));
    }
}
