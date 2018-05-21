package ua.com.owu.service.user.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.owu.entity.User;
import ua.com.owu.service.user.UserService;

import java.beans.PropertyEditorSupport;

@Component
public class UserEditor extends PropertyEditorSupport {

    @Autowired
    private UserService userService;

    @Override
    public void setAsText(String idOfUser) throws IllegalArgumentException {
        System.out.println(idOfUser);

        User user = userService.findOne(Integer.parseInt(idOfUser));
        setValue(user);

    }
}
