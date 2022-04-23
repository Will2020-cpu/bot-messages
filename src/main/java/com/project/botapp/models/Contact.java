package com.project.botapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
@Getter
@Setter
public class Contact {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String redSocial;
    private String number;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Message> messages;
}