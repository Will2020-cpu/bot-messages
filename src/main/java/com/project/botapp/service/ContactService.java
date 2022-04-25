package com.project.botapp.service;

import com.project.botapp.models.Contact;
import com.project.botapp.models.Message;
import javassist.NotFoundException;

import java.util.List;

public interface ContactService {
    Contact saveContact(Contact contact);
    Contact editContact(Contact contact, Long id) throws NotFoundException;
    List<Contact> getContacts();
    List<Message> getMessagesByContact(Long id);
    void addMessage(Message message, Long id);
}
