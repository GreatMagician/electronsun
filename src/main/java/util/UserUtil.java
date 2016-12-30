package util;

import model.User;

/**
 * Created by Александр on 30.12.2016.
 */
public class UserUtil {

    public static User prepareToSave(User user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }

}
