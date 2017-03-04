package com.mybot.rest.base;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybot.application.base.GenericService;
import com.mybot.domain.base.CoreEntity;


/**
 * Created by tekalign.bezawork on 3/28/16.
 */
public class GenericController<E extends CoreEntity> {

    GenericService<E> genericService;

    public GenericController(GenericService<E> genericService) {
        this.genericService = genericService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<E> create(@RequestBody E entity) {
        try {
            E ret = genericService.create(entity);
            return new ResponseEntity<E>(ret, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<E> get(@PathVariable("id") String id) {
        try {
            E entity = genericService.get(id);
            return new ResponseEntity<E>(entity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<E>> getAll() {
        try {
            return new ResponseEntity<List<E>>(genericService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> remove(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<Boolean>(genericService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<E> editPerson(@RequestBody E entity) {
        try {
            return new ResponseEntity<E>(genericService.update(entity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
