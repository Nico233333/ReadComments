package com.comment.readcomments.repository;

import com.comment.readcomments.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository {
    UserEntity selectUserByIdAndPass(String userId, String password);

    int insertUser(UserEntity userEntity);


}
