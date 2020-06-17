package com.ito.notifico.lineanegocio.service;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;


public interface IGenericNoPageService<T> {
    T findByName(String username) throws ResourceNotFoundException;

    T create(T T);

    void delete(T T) throws ResourceNotFoundException;

    void deleteById(int id) throws ResourceNotFoundException;

    Iterable<T> findAll();

    T findById(int id) throws ResourceNotFoundException;

    T update(T T) throws ResourceNotFoundException;

}
