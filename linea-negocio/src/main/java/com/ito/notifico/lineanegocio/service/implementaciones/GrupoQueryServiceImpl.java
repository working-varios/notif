package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.GrupoQueryEntity;
import com.ito.notifico.lineanegocio.repository.GrupoQueryRepository;
import com.ito.notifico.lineanegocio.service.IGenericBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoQueryServiceImpl implements IGenericBasicService<GrupoQueryEntity> {
    @Autowired
    private GrupoQueryRepository repository;

    @Override
    public GrupoQueryEntity findByNombre(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null) {
            return repository.findByNombre(nombre);
        } else {
            throw new ResourceNotFoundException("GrupoQuery", "nombre", nombre);
        }
    }

    @Override
    public Iterable<GrupoQueryEntity> findAll() {
        List<GrupoQueryEntity> lista = (List<GrupoQueryEntity>) repository.findAll();
        return lista;
    }

    @Override
    public GrupoQueryEntity findByCodigo(String codigo) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public GrupoQueryEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("GrupoQuery", "id", Integer.toString(id));
        }
    }

}
