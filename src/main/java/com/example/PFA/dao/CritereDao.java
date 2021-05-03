package com.example.PFA.dao;

import com.example.PFA.bean.Critere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CritereDao extends JpaRepository<Critere,Long> {

    Critere findCritereByCritereName(String critereName);
}
