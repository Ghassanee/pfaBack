package com.example.PFA.rest;

import com.example.PFA.bean.Admin;
import com.example.PFA.bean.Projet;
import com.example.PFA.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/admin")
public class AdminRest {

    @Autowired
    private AdminService adminService;



    @GetMapping("email/{email}")
    public Admin findAdminByEmail(@PathVariable("email") String email) {
        return adminService.findAdminByEmail(email);
    }

    @PostMapping("register/")
    public Admin registerAdmin(@RequestBody Admin admin) {
        Admin foundedAdmin = adminService.registerAdmin(admin);
        if (foundedAdmin != null) return foundedAdmin;
        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,  "email or login already exist"
        );
    }

    @PostMapping("login/")
    public Admin loginAdmin(@RequestBody Admin admin) {
        Admin foundedAdmin = adminService.loginAdmin(admin.getLogin(), admin.getPassword());
        if (foundedAdmin != null) return foundedAdmin;
        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,  "username or password wrong"
        );
    }

    @GetMapping("projets/{adminLogin}")
    public ArrayList<Projet> findByAdmin(@PathVariable String adminLogin) {

        return adminService.findByAdmin(adminLogin);
    }

}
