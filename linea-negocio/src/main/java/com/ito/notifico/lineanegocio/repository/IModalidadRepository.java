package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.ModalidadEntity;
import com.ito.notifico.lineanegocio.model.ModalidadEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IModalidadRepository  extends CrudRepository<ModalidadEntity,Integer> {
    Page<ModalidadEntity> findAll(Pageable paging);
    ModalidadEntity findByNombre(String nombre);
}
