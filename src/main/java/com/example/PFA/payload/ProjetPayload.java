package com.example.PFA.payload;

import com.example.PFA.bean.Expert;
import com.example.PFA.bean.Projet;

import java.util.List;

public class ProjetPayload {

    private Projet projet;
    private List<Expert> experts;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<Expert> getExperts() {
        return experts;
    }

    public void setExperts(List<Expert> experts) {
        this.experts = experts;
    }
}
