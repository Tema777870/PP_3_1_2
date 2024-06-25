package com.example.PP_3_1_2.service;


import com.example.PP_3_1_2.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> listAll();

    User get(int id);

    void delete(int id);

    User findByEmail(String email);
}
