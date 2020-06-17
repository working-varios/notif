package com.ito.notifico.lineanegocio.service;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.LineanegocioEntity;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;

public interface ILineanegocioService {
    public LineanegocioEntity findByName(String username) throws ResourceNotFoundException;

    LineanegocioEntity create(LineanegocioEntity LineanegocioEntity);

    void delete(LineanegocioEntity LineanegocioEntity) throws ResourceNotFoundException;

    void deleteById(int id) throws ResourceNotFoundException;

    Iterable<LineanegocioEntity> findAll();

    LineanegocioEntity findById(int id) throws ResourceNotFoundException;

    LineanegocioEntity update(LineanegocioEntity LineanegocioEntity) throws ResourceNotFoundException;

    ResultSearchData<LineanegocioEntity> findAllSearch(int page, int size, String orderBy, String sort);
}
