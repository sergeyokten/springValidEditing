package ua.com.owu.service.user.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.owu.entity.User;

@Component
public class UserValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getName().equals("loh")) {
            errors.rejectValue("name", "", "wrong name");
        }

    }
}
