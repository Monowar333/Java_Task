/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.web.validate;

import akvelon.domain.Users;
import akvelon.service.UsersService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 *
 * @author Жека
 * Validate users with org.springframework.validation.Validator
 */
 @Component
public class UsersValidate implements Validator {
         @Autowired
         ValidateRegular regular;
         
         BigDecimal b;
         BigDecimal b1;
        
        private final String name = ValidatePattern.name.pattern();
        private final String login_pass = ValidatePattern.login_pass.pattern();

        @Autowired
        UsersService userService;
            
        @Override
	public boolean supports(Class<?> clazz) {
		return Users.class.isAssignableFrom(clazz);
	}
        
        @Override
	public void validate(Object target, Errors errors) {
            
		Users users = (Users) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "username must not be empty.");
		String login = users.getUsername();
		if (16 < (login.length())) {
                    errors.rejectValue("username", "username.tooLong", "username must not more than 16 characters.");
		}else if(false == regular.regular(login, login_pass)){
                    errors.rejectValue("username", "username.falsform", "username must have only A-Z,a-z,0-9.");
                    }
                
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "name must not be empty.");
		if(false == regular.regular(users.getName(), name)){
                    errors.rejectValue("name", "name.falsform", "Firstname  must have only A-Z,a-z.");
                }
                
                
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "statusregistr", "statusregistr.empty", "statusregistr must not be empty.");
		if(((true) != users.getStatusregistr())&&((false) != users.getStatusregistr())){
                    errors.rejectValue("statusregistr", "statusregistr.falsform", "statusregistr  must be true or false.");
                }
                
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
		 if(false == regular.regular(users.getPassword(), login_pass)){
                    errors.rejectValue("password", "password.falsform", "password must have only A-Z,a-z,0-9.");
                }
                 
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "weight.empty", "weight must not be empty.");
                     b = new BigDecimal(0.0);
                     b1 = new BigDecimal(500.0);
                     if( (null == users.getWeight()) ||
                             ((b.longValue()) > users.getWeight().longValue())
                             || ((b1.longValue()) < users.getWeight().longValue())){
                    errors.rejectValue("weight", "weight.falsform", "weight  must be more 0.");
                }
                
                 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.empty", "role must not be empty.");
		if(false == regular.regular(users.getRole(), name)){
                    errors.rejectValue("role", "role.falsform", "role  must have only A-Z,a-z");
                }
                
                     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.empty", "age must not be empty.");
                     if(((0) > users.getAge())
                             || ((300) < users.getAge())){
                    errors.rejectValue("age", "age.falsform", "age  must be more 0.");
                }
               
	}
        
      
    
}

