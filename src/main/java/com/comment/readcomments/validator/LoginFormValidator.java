package com.comment.readcomments.validator;

import com.comment.readcomments.form.LoginForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginFormValidator {

    public List<String> validate(LoginForm form) {
        List<String> result = new ArrayList<>();
        //check userID
        checkUserId(form.getName(),result);
        //check password
        checkPassword(form.getPassword(),result);
        return result;
    }

        private void checkUserId(String id, List<String>  result){
            if (StringUtils.isBlank(id))
            {
                result.add("请输入用户名");
            }
            else if (id.length() > 20 ){
                result.add("用户ID长度不能大于20");
            }
        }

        private void checkPassword(String password, List<String> result){
            if (StringUtils.isBlank(password))
            {
                result.add("请输入密码");
            }
            else if (password.length() > 20 ){
                result.add("密码长度不能大于20");
            }
    }



}



