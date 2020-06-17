package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface IUsuarioRepository  extends CrudRepository<UsuarioEntity,Integer> {
    UsuarioEntity findByUsernameAndPassword(String user, String password);
}

