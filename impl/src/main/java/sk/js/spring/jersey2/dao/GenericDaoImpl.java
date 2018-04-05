package sk.js.spring.jersey2.dao;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author jan.sedlak on 4/4/2018.
 */
public class GenericDaoImpl<PK extends Serializable, T> implements BaseDAO<PK, T> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<T> entityClass;

    public GenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public void create(T newInstance) {
        this.entityManager.persist(newInstance);
    }

    @Override
    public T find(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T instance) {
        return this.entityManager.merge(instance);
    }
}
