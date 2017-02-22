package util.exception;

/**
 * Created by Александр on 17.02.2017.
 * возникает когда нет прав на выбранное действие.
 */
public class AccessException  extends RuntimeException {
    public AccessException(String message) {
        super(message);
    }
}