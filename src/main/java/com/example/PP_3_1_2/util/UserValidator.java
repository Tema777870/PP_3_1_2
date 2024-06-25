package com.example.PP_3_1_2.util;

import com.example.PP_3_1_2.model.User;
import com.example.PP_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserService userService;


    @Autowired
    public UserValidator(UserService userService) {

        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if ((userService.findByEmail(user.getEmail()) != null)) {
            errors.rejectValue("email", "", "This email is already taken");
        }
    }
}
