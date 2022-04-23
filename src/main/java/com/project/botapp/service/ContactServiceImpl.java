package com.project.botapp.service;

import com.project.botapp.models.Contact;
import com.project.botapp.models.Message;
import com.project.botapp.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor @Transactional
@Slf4j
public class ContactServiceImpl  implements ContactService{

    @Autowired
    private ContactRepo contactRepo;


    @Override
    public Contact saveContact(Contact contact) {
        if (contact.getRedSocial().equalsIgnoreCase("Whatsapp") && contact.getNumber() == null){
            return null;
        }
         return contactRepo.save(contact);
    }

    @Override
    public Contact editContact(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    @Override
    public List<Message> getMessagesByContact(Contact contact) {
        return null;
    }
}
