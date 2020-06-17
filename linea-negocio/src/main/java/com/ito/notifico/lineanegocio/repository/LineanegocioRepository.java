package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.LineanegocioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface LineanegocioRepository  extends CrudRepository<LineanegocioEntity,Integer> {
    Page<LineanegocioEntity> findAll(Pageable paging);
    Page<LineanegocioEntity> findAllByUsuarioid(Pageable paging, int usuarioId);
    LineanegocioEntity findByNombre(String nombre);
}
