package model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Александр on 05.11.2016.
 */
public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_OPERATOR; // для обработки заказов

    @Override
    public String getAuthority() {
        return name();
    }

}
