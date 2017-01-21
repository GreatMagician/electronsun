package util.exception;

/**
 * Created by Александр on 20.01.2017.
 * Пользователь удалён
 */
public class UserDeletedException extends RuntimeException {
    public UserDeletedException(String message) {
        super(message);
    }
}

