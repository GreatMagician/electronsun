package util;

import model.User;
import to.UserTo;

/**
 * Created by Александр on 30.12.2016.
 */
public class UserUtil {

    public static User prepareToSave(User user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }

    public static UserTo createUserTo(User user){
        if (user == null){
            return new UserTo(null, null, true);
        }
        return new UserTo(user.getId(), user.getName(), user.isEnabled());
    }

}
