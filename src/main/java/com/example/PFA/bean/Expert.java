package com.example.PFA.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String expertName;
    private String password;
    private String email;
    private String login;
    private String answers;


    @ManyToOne(
            cascade = CascadeType.ALL)
    private Projet projet;
}
