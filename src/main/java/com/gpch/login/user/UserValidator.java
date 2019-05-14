package com.gpch.login.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService){
        this.userService = userService;
    }
    @Override
    public boolean supports(Class<?> aClass)
    {
        return User.class.equals(aClass);
    }
    @Override
    public void validate(Object o, Errors errors)
    {

    }
}
