package com.comment.readcomments.controller;


import com.comment.readcomments.exception.ValidationErrorException;
import com.comment.readcomments.form.RegisterForm;
import com.comment.readcomments.service.RegisterService;
import com.comment.readcomments.validator.RegisterFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private RegisterFormValidator registerFormValidator;

    @PostMapping("/register")
    public boolean register(@RequestBody RegisterForm form) throws Exception{
        List<String> errorMsgs = registerFormValidator.validate(form);
        System.out.println(form);
        if (!errorMsgs.isEmpty()){
            throw new ValidationErrorException(errorMsgs);
        }
        return registerService.register(form);
    }

}
