package com.example.PFA.service;

import com.example.PFA.bean.Expert;
import com.example.PFA.bean.Projet;
import com.example.PFA.dao.ExpertDao;
import com.example.PFA.dao.ProjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ExpertService {

    @Autowired
    private ExpertDao expertDao;


    @Autowired
    private ProjetDao projetDao;

    public Expert findExpertByLogin(String login) {
        return expertDao.findExpertByLogin(login);
    }

    public int registerExpert(Expert admin) {
        if (expertDao.findExpertByLogin(admin.getLogin()) != null) return -1;
        expertDao.save(admin);
        return 1;
    }

    public Expert loginExpert(String login, String password) {
        return expertDao.findExpertByLoginAndPassword(login, password);
    }

    public int answer(Expert expert) {
        Expert foundedExpert = expertDao.findExpertByLogin(expert.getLogin());
        if (foundedExpert == null) return -1;
        foundedExpert.setAnswers(expert.getAnswers());
        expertDao.save(foundedExpert);
        return 1;
    }
}
