package com.example.PFA.dao;

import com.example.PFA.bean.Admin;
import com.example.PFA.bean.Expert;
import com.example.PFA.bean.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public interface ProjetDao extends JpaRepository<Projet,Long> {

    Projet findProjetByProjetName(String name);

    ArrayList<Projet> findAllByAdmin(Admin admin);

}
