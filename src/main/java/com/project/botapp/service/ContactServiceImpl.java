package com.project.botapp.service;

import com.project.botapp.constants.SocialNetwork;
import com.project.botapp.exception.ConflictException;
import com.project.botapp.exception.NotFoundException;
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
            throw new ConflictException();
        }
         return contactRepo.save(contact);
    }

    @Override
    public Contact editContact(Contact contact, Long id)  {
        if (!contactRepo.existsById(id)){
            log.info("Not found contact {}",contact.getName());
           throw new NotFoundException();
        }
        return this.saveContact(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    @Override
    public List<Message> getMessagesByContact(Long id) {
        if (!contactRepo.existsById(id)){
            throw new NotFoundException();
        }
        return (List<Message>) contactRepo.getById(id).getMessages();
    }

    @Override
    public void addMessage(Message message, Long id) {
        if (!contactRepo.existsById(id)){
            log.info("Contacto no existe");
            throw new ConflictException();
        }
        Contact contact = contactRepo.getById(id);
        log.info("Adding message {} to Contact {}", message.getMessage(), contact.getName());
        if (contact.getSocialNetwork().getSocial().equalsIgnoreCase(SocialNetwork.WHATSAPP.getSocial()) && contact.getNumber() == null){
            throw new ConflictException();
        }
        messageRepo.save(message);
        contact.getMessages().add(message);
    }
}
