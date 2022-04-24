package com.project.botapp.service;

import com.project.botapp.models.Contact;
import com.project.botapp.models.Message;

import java.util.List;

public interface ContactService {
    Contact saveContact(Contact contact);
    Contact editContact(Contact contact);
    List<Contact> getContacts();
    List<Message> getMessagesByContact(Contact contact);
    Message addMessage(Message message, Long id);
}
