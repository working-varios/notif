package com.ito.notifico.lineanegocio.service;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.GrupoEntity;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;

public interface IGrupoService {
    GrupoEntity findByName(String username) throws ResourceNotFoundException;

    GrupoEntity create(GrupoEntity GrupoEntity);

    void delete(GrupoEntity GrupoEntity) throws ResourceNotFoundException;

    void deleteById(int id) throws ResourceNotFoundException;

    Iterable<GrupoEntity> findAll();

    GrupoEntity findById(int id) throws ResourceNotFoundException;

    GrupoEntity update(GrupoEntity GrupoEntity) throws ResourceNotFoundException;

    ResultSearchData<GrupoEntity> findAllSearch(int page, int size);
}
