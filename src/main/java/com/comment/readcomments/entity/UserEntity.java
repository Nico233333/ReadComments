package com.comment.readcomments.entity;

import lombok.Data;

@Data
public class UserEntity {
    private String user_id;
    private String name;
    private String password;
    private String organization_id;
    private String authority;
}
