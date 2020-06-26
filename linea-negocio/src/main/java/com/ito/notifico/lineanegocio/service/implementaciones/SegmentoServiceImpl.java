package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.SegmentoEntity;
import com.ito.notifico.lineanegocio.repository.ISegmentoRepository;
import com.ito.notifico.lineanegocio.service.IGenericBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentoServiceImpl implements IGenericBasicService<SegmentoEntity> {
    @Autowired
    private ISegmentoRepository repository;

    @Override
    public SegmentoEntity findByNombre(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null) {
            return repository.findByNombre(nombre);
        } else {
            throw new ResourceNotFoundException("Segmento", "nombre", nombre);
        }
    }

    @Override
    public Iterable<SegmentoEntity> findAll() {
        List<SegmentoEntity> lista = (List<SegmentoEntity>) repository.findAll();
        return lista;
    }

    @Override
    public SegmentoEntity findByCodigo(String codigo) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public SegmentoEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Segmento", "id", Integer.toString(id));
        }
    }

}
