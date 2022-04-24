package com.project.botapp;

import com.project.botapp.constants.SocialNetwork;
import com.project.botapp.models.Contact;
import com.project.botapp.models.Message;
import com.project.botapp.service.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class BotAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactService contactService){
		return args -> {
			Contact contact =new Contact(null,"Willian","3126296849",new ArrayList<>(), SocialNetwork.WHATSAPP);
			contactService.saveContact(contact);
			Message message = new Message(null, "Que onda ?");
			contactService.addMessage(message,1L);
		};
	}
}
