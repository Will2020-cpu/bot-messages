package com.project.botapp.repository;

import com.project.botapp.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Long> {
}
