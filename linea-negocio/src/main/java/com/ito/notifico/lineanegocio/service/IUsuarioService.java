package com.ito.notifico.lineanegocio.service;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.UsuarioEntity;
import org.springframework.stereotype.Service;

public interface IUsuarioService {
    public UsuarioEntity findByUsernameAndPassword(String user, String password) throws ResourceNotFoundException;
}
