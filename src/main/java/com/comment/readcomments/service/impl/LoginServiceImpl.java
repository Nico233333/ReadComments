package com.comment.readcomments.service.impl;

import com.comment.readcomments.entity.UserEntity;
import com.comment.readcomments.repository.UserRepository;
import com.comment.readcomments.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity login(String userId, String password) {
      return userRepository.selectUserByIdAndPass(userId,password);
    }
}
