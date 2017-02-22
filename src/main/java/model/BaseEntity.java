package model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

import static javax.persistence.FlushModeType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Александр on 05.11.2016.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements Persistable<Long> {

    @Id
    @Access(value = AccessType.PROPERTY)
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Long id;

    public BaseEntity() {
    }

    protected BaseEntity(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return (this.id == null);
    }

}
