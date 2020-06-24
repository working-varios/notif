package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.DepartamentoEntity;
import com.ito.notifico.lineanegocio.model.GrupoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentoRepository extends CrudRepository<DepartamentoEntity,Integer> {
    Page<DepartamentoEntity> findAll(Pageable paging);
    DepartamentoEntity findByNombre(String nombre);
}
