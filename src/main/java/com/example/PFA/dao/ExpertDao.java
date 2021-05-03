package com.example.PFA.dao;

import com.example.PFA.bean.Expert;
import com.example.PFA.bean.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository

public interface ExpertDao extends JpaRepository<Expert, Long> {

    Expert findExpertByLoginAndPassword(String login, String password);

    Expert findExpertByLogin(String login);

    ArrayList<Expert> findAllByProjet(Projet projet);
}
