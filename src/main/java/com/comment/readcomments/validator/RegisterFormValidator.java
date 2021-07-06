package com.comment.readcomments.validator;

import com.comment.readcomments.form.RegisterForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterFormValidator {

    public List<String> validate(RegisterForm form) {
        List<String> result = new ArrayList<>();
        //check userID
        checkName(form.getName(),result);
        //check password
        checkPassword(form.getPassword(),form.getRetypePassword(),result);
        //check organization_id()
        checkOrganization_id(form.getOrganization_id(),result);

        return result;
    }

    private void checkOrganization_id(String organization_id, List<String>  result) {
        if (StringUtils.isBlank(organization_id)){
            result.add("请选择你的身份");
        }
    }


    private void checkName(String id, List<String>  result){
            if (StringUtils.isBlank(id))
            {
                result.add("请输入用户名");
            }
            else if (id.length() > 15 ){
                result.add("用户名的长度不能大于15");
            }
        }

        private void checkPassword(String password,String retypePassword,
                                   List<String> result){
            if (StringUtils.isBlank(password))
            {
                result.add("请输入密码");
            }
            else if (StringUtils.isBlank(retypePassword))
            {
                result.add("请再次输入密码");
            }
            else if (!password.equals(retypePassword)){
                result.add("请输入确认两次输入的密码是否相同");
            }
            else if (password.length() > 20 ){
                result.add("密码的长度不能大于20");
            }
    }



}



