package util.exception;


import model.Role;
import model.User;
import util.AuthorizedUser;

import java.util.Objects;

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
            throw new NotFoundException("Данные не найдены для " + msg);
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

    /**
     *  Проверка прав действий пользователя
     *  Если проверка не проходит бросить исключение
     * @param user
     */
    public static void checkAccessUser(User user)  {
        User authorizedUser = AuthorizedUser.get().getUser();
        if (!Objects.equals(authorizedUser.getId(), user.getId()) &&
                !Objects.equals(authorizedUser.getName(), user.getName()) &&
                !Objects.equals(authorizedUser.getPassword(), user.getPassword())){
                throw new AccessException("У вас нет прав на это действие");
        }
    }

}
