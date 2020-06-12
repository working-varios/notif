package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.dto.GrupoDto;
import com.ito.notifico.lineanegocio.model.GrupoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface GrupoRepository extends CrudRepository<GrupoEntity,Integer> {
    Page<GrupoEntity> findAll(Pageable paging);
    public GrupoEntity findByNombre(String nombre);
}
