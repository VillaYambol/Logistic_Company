package com.company.service;


import com.company.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.LinkedList;
import java.util.List;

public interface UserService extends UserDetailsService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUserName(String name);

    UserServiceModel editUserProfile(UserServiceModel userServiceModel,String oldPassword);

    List<UserServiceModel> findAllUsers();

    void setUserRole(String id,String role);

    UserServiceModel findUserById(String id);
}
