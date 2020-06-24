package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.MunicipioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IMunicipioRepository extends CrudRepository<MunicipioEntity,Integer> {
    Page<MunicipioEntity> findAll(Pageable paging);
    MunicipioEntity findByNombre(String nombre);
}
