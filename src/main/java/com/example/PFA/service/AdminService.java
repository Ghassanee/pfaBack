package com.example.PFA.service;

import com.example.PFA.bean.Admin;
import com.example.PFA.bean.Projet;
import com.example.PFA.dao.AdminDao;
import com.example.PFA.dao.ProjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private ProjetDao projetDao;

    public Admin findAdminByEmail(String email) {
        return adminDao.findAdminByEmail(email);
    }

    public Admin registerAdmin(Admin admin){
        if (adminDao.findAdminByEmail(admin.getEmail()) != null || adminDao.findAdminByLogin(admin.getLogin()) != null) return null;
        adminDao.save(admin);
        return admin;
    }
    public ArrayList<Projet> findByAdmin(String adminLogin){
        Admin foundedAdmin = adminDao.findAdminByLogin(adminLogin);
        return projetDao.findAllByAdmin(foundedAdmin);
    }
    public Admin loginAdmin(String login, String password){
        Admin foundedAdmin =  adminDao.findAdminByLoginAndPassword(login,password );
        return foundedAdmin;
    }

}
