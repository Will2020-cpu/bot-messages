package com.project.botapp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message")
@Getter
@Setter
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;

}
