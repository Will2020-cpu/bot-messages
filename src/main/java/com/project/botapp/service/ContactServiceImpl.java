package com.project.botapp.service;

import com.project.botapp.constants.SocialNetwork;
import com.project.botapp.models.Contact;
import com.project.botapp.models.Message;
import com.project.botapp.repository.ContactRepo;
import com.project.botapp.repository.MessageRepo;
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

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public Contact saveContact(Contact contact) {
        if (contact.getSocialNetwork().getSocial().equalsIgnoreCase(SocialNetwork.WHATSAPP.getSocial()) && contact.getNumber() == null){
            log.info("The number is null");
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

    @Override
    public Message addMessage(Message message, Long id) {
        if (!contactRepo.existsById(id)){
            log.info("Contacto no existe");
            return null;
        }
        Contact contact = contactRepo.getById(id);
        log.info("Adding message {} to Contact {}", message.getMessage(), contact.getName());
        if (contact.getSocialNetwork().getSocial().equalsIgnoreCase(SocialNetwork.WHATSAPP.getSocial()) && contact.getNumber() == null){
            return null;
        }
        messageRepo.save(message);
        contact.getMessages().add(message);
        return message;
    }
}
