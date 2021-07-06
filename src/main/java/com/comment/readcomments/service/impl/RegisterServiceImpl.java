package com.comment.readcomments.service.impl;

import com.comment.readcomments.entity.UserEntity;
import com.comment.readcomments.exception.ValidationErrorException;
import com.comment.readcomments.form.RegisterForm;
import com.comment.readcomments.repository.UserRepository;
import com.comment.readcomments.service.RegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean register(RegisterForm form) {
        UserEntity user=new UserEntity();
        BeanUtils.copyProperties(form,user);
        user.setAuthority("0");
        try {
            userRepository.insertUser(user);
        }
        catch (DuplicateKeyException e){
            throw new ValidationErrorException(Arrays.asList("用户名已经存在，请输入其他的用户名"));
        }
        return true;
    }
}
