package com.ito.notifico.lineanegocio.service;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.GrupoEntity;
import com.ito.notifico.lineanegocio.repository.GrupoRepository;
import com.ito.notifico.lineanegocio.shared.BaseService;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl extends BaseService<GrupoEntity> implements IGrupoService {
    @Autowired
    private GrupoRepository repository;

    @Override
    public GrupoEntity findByName(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null)
        {
            return repository.findByNombre(nombre) ;
        }
        else
        {
            throw new ResourceNotFoundException("Grupo", "nombre",  nombre);
        }
    }

    @Override
    public GrupoEntity create(GrupoEntity GrupoEntity) {
        return repository.save(GrupoEntity);
    }

    @Override
    public void delete(GrupoEntity GrupoEntity) throws ResourceNotFoundException {
        if (repository.findById(GrupoEntity.getId()).isPresent())
        {
            repository.delete(GrupoEntity);
        }
        throw new ResourceNotFoundException("Grupo", "id",  Integer.toString(GrupoEntity.getId()));
    }

    @Override
    public void deleteById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent())
        {
            repository.deleteById(id);
        }
        else
        {
            throw new ResourceNotFoundException("Grupo", "id", Integer.toString(id));
        }
    }

    @Override
    public Iterable<GrupoEntity> findAll() {
        List<GrupoEntity> lista = (List<GrupoEntity>) repository.findAll();
        return lista;
    }

    @Override
    public GrupoEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent())
        {
            return repository.findById(id).get();
        }
        else
        {
            throw new ResourceNotFoundException("Grupo", "id",  Integer.toString(id));
        }
    }

    @Override
    public GrupoEntity update(GrupoEntity GrupoEntity) throws ResourceNotFoundException {
        if (repository.findById(GrupoEntity.getId()).isPresent())
        {
            return repository.save(GrupoEntity);
        }
        throw new ResourceNotFoundException("Grupo", "id", Integer.toString(GrupoEntity.getId()));
    }

    @Override
    public ResultSearchData<GrupoEntity> findAllSearch(int page, int size) {
        Pageable paging = PageRequest.of(page, size );
        Page<GrupoEntity> pagedResult = repository.findAll(paging);
        return (ResultSearchData<GrupoEntity>) this.getResultSearch(pagedResult);
    }

}
