package sk.js.spring.jersey2.dao;

import java.io.Serializable;

/**
 * @author jan.sedlak on 4/4/2018.
 */
public interface BaseDAO<PK extends Serializable, T> {

    void create(T newInstance);

    T find(PK id);

    T update(T instance);
}
