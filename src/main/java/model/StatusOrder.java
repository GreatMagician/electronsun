package model;

import javax.persistence.Entity;
import javax.persistence.JoinTable;

/**
 * Created by Александр on 22.11.2016.
 */
public enum StatusOrder {
    /**
     *  Ожидание оплаты
     */
    PENDING_PAYMENT,
    /**
     * Ожидает обработки
     */
    PENDING,
    /**
     * обработка
     */
    TREATMENT,
    /**
     * отправлено
     */
    SENT;

}
