package util.exception;

/**
 * Created by Александр on 03.12.2016.
 * Превышение значения или значение не попадает в диапазон
 */
public class ExcessValueException extends RuntimeException {
    public ExcessValueException(String message) {
        super(message);
    }
}