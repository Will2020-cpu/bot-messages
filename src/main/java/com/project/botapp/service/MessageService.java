package com.project.botapp.service;

import com.project.botapp.models.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    Message editMessage(Message message);
    List<Message> getMessages();
}
