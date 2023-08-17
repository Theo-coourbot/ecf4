package com.authentification.authentification.service;


import com.authentification.authentification.entity.UserApp;
import com.authentification.authentification.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAppService {

    @Autowired
    private  UserAppRepository _userAppRepository;


    public UserApp saveUser(String pseudo, String password) {
        UserApp user = new UserApp(pseudo, password);
        return _userAppRepository.save(user);
    }

}
