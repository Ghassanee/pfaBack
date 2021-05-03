package com.example.PFA.dao;

import com.example.PFA.bean.FuzzyAHP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FuzzyAhpDao extends JpaRepository<FuzzyAHP,Long> {
}
