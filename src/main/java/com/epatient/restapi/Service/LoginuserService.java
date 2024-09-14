package com.epatient.restapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.epatient.restapi.Models.ModelAppLoginUser;
import com.epatient.restapi.Repository.AppLoginuserRepository;
import java.util.*;

@Service
public class LoginuserService {
	@Autowired
    private AppLoginuserRepository userRepository;

    public List<ModelAppLoginUser> searchByUsernameOrMobile(@RequestParam("input") String input) {
        return userRepository.findByUsernameOrMobile(input);
    }
//    public boolean isAppLoingUserActive(String username) {
//        Optional<ModelAppLoginUser> user = userRepository.findByUsernameAndStatus(username, "active");
//        return user.isPresent();
//    }

}
