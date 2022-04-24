package com.project.botapp.models;

import com.project.botapp.constants.SocialNetwork;
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
    private String number;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Message> messages;

    @Enumerated(EnumType.ORDINAL)
    private SocialNetwork socialNetwork;
}