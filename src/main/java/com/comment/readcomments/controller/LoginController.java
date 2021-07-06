package com.comment.readcomments.controller;


import com.comment.readcomments.entity.UserEntity;
import com.comment.readcomments.exception.ValidationErrorException;
import com.comment.readcomments.form.LoginForm;
import com.comment.readcomments.service.LoginService;
import com.comment.readcomments.validator.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class LoginController {

        @Autowired
        public LoginService loginService;

        @Autowired
        public LoginFormValidator loginFormValidator;

        @PostMapping("/login")
        public UserEntity login(@RequestBody LoginForm form) throws ValidationErrorException{

                List<String> errorMsgs=loginFormValidator.validate(form);

                if (!errorMsgs.isEmpty()){
                throw new ValidationErrorException(errorMsgs);
                }

                return loginService.login(form.getName(),form.getPassword());
        }




}
