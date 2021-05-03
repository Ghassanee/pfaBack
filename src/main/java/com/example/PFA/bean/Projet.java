package com.example.PFA.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String projetName;
    private String description;
    @ManyToOne
    private Admin admin;
    @ElementCollection
    private List<String> reponses;

    @OneToMany(
            cascade = CascadeType.ALL)
    private List<Critere> criteres;




}
