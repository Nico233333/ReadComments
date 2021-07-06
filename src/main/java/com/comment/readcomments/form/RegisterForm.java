package com.comment.readcomments.form;

import lombok.Data;

@Data
public class RegisterForm
{
    private String user_id;
    private String name;
    private String password;
    private String retypePassword;
    private String organization_id;
    private String authority;

    @Override
    public String toString() {
        return "RegisterForm{" +
                "userId='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                ", organization_id='" + organization_id + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
