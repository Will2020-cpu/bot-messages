package com.project.botapp.models;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Messages {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Contact> contacts = new ArrayList<>();
}
