package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.UsuarioEntity;
import com.ito.notifico.lineanegocio.repository.IUsuarioRepository;
import com.ito.notifico.lineanegocio.service.IUsuarioService;
import com.ito.notifico.lineanegocio.shared.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseService<UsuarioEntity> implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public UsuarioEntity findByUsernameAndPassword(String username, String password) throws ResourceNotFoundException {
        UsuarioEntity user = repository.findByUsernameAndPassword(username, password);
        if ( user != null) {
            return user;
        } else {
            throw new ResourceNotFoundException("Usuario", "nombre", username);
        }
    }
}