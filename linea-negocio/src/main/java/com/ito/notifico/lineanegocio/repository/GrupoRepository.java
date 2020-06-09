package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.dto.GrupoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface GrupoRepository extends CrudRepository<GrupoDto,Integer> {
    Page<GrupoDto> findAll(Pageable paging);
    public GrupoDto findByNombre(String nombre);
}
