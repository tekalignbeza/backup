package com.mybot.application.base;

import java.util.List;

import com.mybot.domain.base.CoreEntity;
import com.mybot.integration.base.GenericDao;

/**
 * Created by tekalign.bezawork on 12/28/16.
 */



public class GenericServiceImp<E extends CoreEntity> implements GenericService<E> {

    GenericDao<E> genericDao;

    public GenericServiceImp(GenericDao<E> genericDao) {
        this.genericDao = genericDao;
    }

    public E get(String id) {
        return genericDao.get(id);
    }

    public List<E> getAll() {
        return genericDao.getAll();
    }

    public E create(E entity) {
       return genericDao.create(entity);
    }

    public E update(E entity) {
       return genericDao.update(entity);
    }

    public boolean delete(String id) {
        return genericDao.delete(id);
    }
}
