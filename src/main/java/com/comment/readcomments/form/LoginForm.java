package com.comment.readcomments.form;

import lombok.Data;

@Data
public class LoginForm
{
            private String name;
            private String password;



    @Override
    public String toString() {
        return "LoginForm{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
