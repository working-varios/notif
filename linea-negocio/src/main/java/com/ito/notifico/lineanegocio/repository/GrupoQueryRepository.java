package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.GrupoQueryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface GrupoQueryRepository extends CrudRepository<GrupoQueryEntity,Integer> {
    Page<GrupoQueryEntity> findAll(Pageable paging);
    GrupoQueryEntity findByNombre(String nombre);
}
