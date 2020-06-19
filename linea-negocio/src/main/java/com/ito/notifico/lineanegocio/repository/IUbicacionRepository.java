package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.UbicacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IUbicacionRepository extends CrudRepository<UbicacionEntity,Integer> {
    Page<UbicacionEntity> findAll(Pageable paging);
    UbicacionEntity findByNombre(String nombre);
}
