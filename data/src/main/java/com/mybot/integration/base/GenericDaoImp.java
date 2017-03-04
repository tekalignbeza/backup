package com.mybot.integration.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import com.mybot.domain.base.CoreEntity;
import com.mybot.domain.user.User;

/**
 * Created by tekalign.bezawork on 3/28/16.
 */


public class GenericDaoImp<E extends CoreEntity> implements GenericDao<E> {

    private static Map<String,CoreEntity> dbMock = new HashMap<String,CoreEntity>();

    public GenericDaoImp(Class<?> entityClass) {
        this.entityClass = entityClass;
        if(dbMock.isEmpty()){
        	List<String> ret = new ArrayList<String>();
        	ret.add("ROLE_USER");
        	dbMock.put("test", new User("test", "test",ret));
        }
    }

    Class<?> entityClass;

    public E get(String id) {
        return (E) dbMock.get(id);
    }

    public List<E> getAll() {
      List<E> ret = new ArrayList<E>();
      for(Map.Entry entry: dbMock.entrySet()){
          ret.add((E) entry.getValue());
      }
      return ret;
    }

    public E create(E entity) {
        if(entity.getId()==null){
            entity.setId(UUID.randomUUID().toString());
        }
        dbMock.put(entity.getId(), entity);
        return get(entity.getId());
    }

    public E update(E entity) {
        dbMock.put(entity.getId(), entity);
        return get(entity.getId());
    }

    public boolean delete(String id) {
        E toDelete = (E) dbMock.get(id);
        if(toDelete!=null){
        dbMock.remove(toDelete);
        return true;
        }
        return false;
    }
}
