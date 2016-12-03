package util.exception;


/**
Обработка ошибок
 */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static void checkNotFoundWithId(boolean found, Long id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, Long id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Объект не найден с " + msg);
        }
    }

    /**
     * Проверка значение на диапозон Byte
     * @param value
     * @return
     */
    public static int checkExcessValueToByte(int value){
        if (value < 0 || value > 255)
            throw new ExcessValueException("Значение должно быть в диапозоне от 0 до 255");
        return value;
    }
}
