package com.mybot.application.base;

import java.util.List;

import com.mybot.domain.base.CoreEntity;

/**
 * Created by tekalign.bezawork on 12/28/16.
 */
public interface GenericService<E extends CoreEntity> {
    public E get(String id);
    public List<E> getAll();
    public E create(E entity);
    public E update(E entity);
    public boolean delete(String id);
}
