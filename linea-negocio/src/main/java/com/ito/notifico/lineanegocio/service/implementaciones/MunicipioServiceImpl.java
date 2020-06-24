package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.MunicipioEntity;
import com.ito.notifico.lineanegocio.repository.IMunicipioRepository;
import com.ito.notifico.lineanegocio.service.IGenericNoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioServiceImpl implements IGenericNoPageService<MunicipioEntity> {
    @Autowired
    private IMunicipioRepository repository;

    @Override
    public MunicipioEntity findByName(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null) {
            return repository.findByNombre(nombre);
        } else {
            throw new ResourceNotFoundException("Ubicacion", "nombre", nombre);
        }
    }

    @Override
    public MunicipioEntity create(MunicipioEntity MunicipioEntity) {
        return repository.save(MunicipioEntity);
    }

    @Override
    public void delete(MunicipioEntity MunicipioEntity) throws ResourceNotFoundException {
        if (repository.findById(MunicipioEntity.getId()).isPresent()) {
            repository.delete(MunicipioEntity);
        }
        throw new ResourceNotFoundException("Ubicacion", "id", Integer.toString(MunicipioEntity.getId()));
    }

    @Override
    public void deleteById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Ubicacion", "id", Integer.toString(id));
        }
    }

    @Override
    public Iterable<MunicipioEntity> findAll() {
        List<MunicipioEntity> lista = (List<MunicipioEntity>) repository.findAll();
        return lista;
    }

    @Override
    public MunicipioEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Ubicacion", "id", Integer.toString(id));
        }
    }

    @Override
    public MunicipioEntity update(MunicipioEntity MunicipioEntity) throws ResourceNotFoundException {
        if (repository.findById(MunicipioEntity.getId()).isPresent()) {
            return repository.save(MunicipioEntity);
        }
        throw new ResourceNotFoundException("Ubicacion", "id", Integer.toString(MunicipioEntity.getId()));
    }

}
