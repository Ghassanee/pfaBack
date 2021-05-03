package com.example.PFA.dao;

import com.example.PFA.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Long> {

    Admin findAdminByEmail(String email);
    Admin findAdminByLogin(String login);
    Admin findAdminByLoginAndPassword(String login , String password);
}
