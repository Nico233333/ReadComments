package com.comment.readcomments.service;

import com.comment.readcomments.entity.UserEntity;

public interface LoginService {
    public UserEntity login(String userId, String password);
}
