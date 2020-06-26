package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.DepartamentoEntity;
import com.ito.notifico.lineanegocio.model.DepartamentoEntity;
import com.ito.notifico.lineanegocio.repository.IDepartamentoRepository;
import com.ito.notifico.lineanegocio.service.IGenericBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements IGenericBasicService<DepartamentoEntity> {
    @Autowired
    private IDepartamentoRepository repository;

    @Override
    public DepartamentoEntity findByNombre(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null) {
            return repository.findByNombre(nombre);
        } else {
            throw new ResourceNotFoundException("Departamento", "nombre", nombre);
        }
    }

    @Override
    public Iterable<DepartamentoEntity> findAll() {
        List<DepartamentoEntity> lista = (List<DepartamentoEntity>) repository.findAll();
        return lista;
    }

    @Override
    public DepartamentoEntity findByCodigo(String codigo) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public DepartamentoEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Departamento", "id", Integer.toString(id));
        }
    }

}
