package com.example.PFA.service;

import com.example.PFA.bean.Expert;
import com.example.PFA.bean.Projet;
import com.example.PFA.dao.AdminDao;
import com.example.PFA.dao.ExpertDao;
import com.example.PFA.dao.ProjetDao;
import com.example.PFA.payload.ProjetPayload;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class ProjetService {


    @Autowired
    private ProjetDao projetDao;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private ExpertDao expertDao;

    public Projet findProjetByProjetName(String name) {
        return projetDao.findProjetByProjetName(name);
    }

    public int createProjet(ProjetPayload projet) {
        Projet foundedProjet = projetDao.findProjetByProjetName(projet.getProjet().getProjetName());
        if (foundedProjet != null) return -1;
        projet.getProjet().setAdmin(adminDao.findAdminByEmail(projet.getEmail()));
        projet.getProjet().setReponses(new ArrayList<String>());
        projetDao.save(projet.getProjet());

        for (Expert expert : projet.getExperts()
        ) {
            expert.setLogin(RandomStringUtils.random(15, 0, 10, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray()));
            expert.setPassword(RandomStringUtils.random(15, 0, 0, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray()));
            expert.setAnswers("");
            expert.setProjet(projet.getProjet());
            sendMailToExpert(expert);
            expertDao.save(expert);
        }
        return 1;
    }

    private void sendMailToExpert(Expert expert) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(expert.getEmail());
        message.setSubject("Expert Mail");
        message.setText("login: " + expert.getLogin() + "\npassword: " + expert.getPassword());
        emailSender.send(message);
    }

    public ArrayList<String> findAnswers(String projetName){
        Projet foundedProjet = projetDao.findProjetByProjetName(projetName);
        if (foundedProjet == null) return null;
        ArrayList<Expert> experts =  expertDao.findAllByProjet(foundedProjet);
        if (experts == null) return null;
        ArrayList<String> answers = new ArrayList<>();
        for (Expert expert : experts
        ){
           answers.add(expert.getAnswers());
        }
        return answers;
    }

}
