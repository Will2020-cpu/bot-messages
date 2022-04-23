package com.project.botapp.models;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message")
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
}
