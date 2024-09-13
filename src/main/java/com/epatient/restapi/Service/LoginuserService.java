package com.epatient.restapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epatient.restapi.Models.ModelAppLoginUser;
import com.epatient.restapi.Repository.AppLoginuserRepository;

@Service
public class LoginuserService {
	@Autowired
    private AppLoginuserRepository userRepository;

    public List<ModelAppLoginUser> searchByUsernameOrEmail(String input) {
        return userRepository.findByUsernameOrMobile(input);
    }

}
