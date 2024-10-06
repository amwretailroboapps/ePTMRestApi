package com.ehrs.restapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ehrs.restapi.Models.ModelAppLoginUser;
import com.ehrs.restapi.Repository.AppLoginuserRepository;

import java.util.*;

@Service
public class LoginuserService {
	@Autowired
    private AppLoginuserRepository userRepository;

    public ModelAppLoginUser searchByUsernameOrMobile(@RequestParam String input) {
        return userRepository.findByUsernameOrMobile(input);
    }
//    public boolean isAppLoingUserActive(String username) {
//        Optional<ModelAppLoginUser> user = userRepository.findByUsernameAndStatus(username, "active");
//        return user.isPresent();
//    }

}
