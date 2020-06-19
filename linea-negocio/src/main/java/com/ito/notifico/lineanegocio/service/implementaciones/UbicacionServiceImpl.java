package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.UbicacionEntity;
import com.ito.notifico.lineanegocio.repository.IUbicacionRepository;
import com.ito.notifico.lineanegocio.service.IGenericNoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServiceImpl implements IGenericNoPageService<UbicacionEntity> {
    @Autowired
    private IUbicacionRepository repository;

    @Override
    public UbicacionEntity findByName(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null) {
            return repository.findByNombre(nombre);
        } else {
            throw new ResourceNotFoundException("Ubicacion", "nombre", nombre);
        }
    }

    @Override
    public UbicacionEntity create(UbicacionEntity UbicacionEntity) {
        return repository.save(UbicacionEntity);
    }

    @Override
    public void delete(UbicacionEntity UbicacionEntity) throws ResourceNotFoundException {
        if (repository.findById(UbicacionEntity.getId()).isPresent()) {
            repository.delete(UbicacionEntity);
        }
        throw new ResourceNotFoundException("Ubicacion", "id", Integer.toString(UbicacionEntity.getId()));
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
    public Iterable<UbicacionEntity> findAll() {
        List<UbicacionEntity> lista = (List<UbicacionEntity>) repository.findAll();
        return lista;
    }

    @Override
    public UbicacionEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Ubicacion", "id", Integer.toString(id));
        }
    }

    @Override
    public UbicacionEntity update(UbicacionEntity UbicacionEntity) throws ResourceNotFoundException {
        if (repository.findById(UbicacionEntity.getId()).isPresent()) {
            return repository.save(UbicacionEntity);
        }
        throw new ResourceNotFoundException("Ubicacion", "id", Integer.toString(UbicacionEntity.getId()));
    }

}
