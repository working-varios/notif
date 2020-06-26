package com.ito.notifico.lineanegocio.service;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;

public interface IGenericBasicService<T> {
        T findByNombre(String username) throws ResourceNotFoundException;


        Iterable<T> findAll();

        T findByCodigo(String codigo) throws ResourceNotFoundException;

        T findById(int id) throws ResourceNotFoundException;

        }