package util.exception;

/**
 * Created by Александр on 16.02.2017.
 *  невозможно удалить световое шоу, так как на него существует ремикс
 *  невозможно изменить данные светового шоу, так как на него существует ремикс
 */
public class LightShowRemixException extends RuntimeException {
    public LightShowRemixException(String message) {
        super(message);
    }
}
