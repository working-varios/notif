package com.ito.notifico.lineanegocio.service;

import com.ito.notifico.lineanegocio.dto.GrupoDto;
import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;

public interface IGrupoService {
    public GrupoDto findByUsername(String username);

    GrupoDto create(GrupoDto GrupoDto);

    void delete(GrupoDto GrupoDto) throws ResourceNotFoundException;

    void deleteById(int id) throws ResourceNotFoundException;

    Iterable<GrupoDto> findAll();

    GrupoDto findById(int id) throws ResourceNotFoundException;

    GrupoDto update(GrupoDto GrupoDto) throws ResourceNotFoundException;

    ResultSearchData<GrupoDto> findAllSearch(int page, int size);
}
