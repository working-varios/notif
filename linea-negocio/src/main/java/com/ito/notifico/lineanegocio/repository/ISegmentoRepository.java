package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.SegmentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ISegmentoRepository extends CrudRepository<SegmentoEntity,Integer> {
    Page<SegmentoEntity> findAll(Pageable paging);
    SegmentoEntity findByNombre(String nombre);
}
