package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.LineanegocioEntity;
import com.ito.notifico.lineanegocio.repository.LineanegocioRepository;
import com.ito.notifico.lineanegocio.service.ILineanegocioService;
import com.ito.notifico.lineanegocio.shared.BaseService;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineanegocioServiceImpl extends BaseService<LineanegocioEntity> implements ILineanegocioService {

@Autowired
private LineanegocioRepository repository;

@Override
public LineanegocioEntity findByName(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null)
        {
        return repository.findByNombre(nombre) ;
        }
        else
        {
        throw new ResourceNotFoundException("Lineanegocio", "nombre",  nombre);
        }
}

@Override
public LineanegocioEntity create(LineanegocioEntity LineanegocioEntity) {
        return repository.save(LineanegocioEntity);
        }

@Override
public void delete(LineanegocioEntity LineanegocioEntity) throws ResourceNotFoundException {
        if (repository.findById(LineanegocioEntity.getId()).isPresent())
        {
        repository.delete(LineanegocioEntity);
        }
        throw new ResourceNotFoundException("Lineanegocio", "id",  Integer.toString(LineanegocioEntity.getId()));
        }

@Override
public void deleteById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent())
        {
        repository.deleteById(id);
        }
        else
        {
        throw new ResourceNotFoundException("Lineanegocio", "id", Integer.toString(id));
        }
        }

@Override
public Iterable<LineanegocioEntity> findAll() {
        List<LineanegocioEntity> lista = (List<LineanegocioEntity>) repository.findAll();
        return lista;
        }

@Override
public LineanegocioEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent())
        {
        return repository.findById(id).get();
        }
        else
        {
        throw new ResourceNotFoundException("Lineanegocio", "id",  Integer.toString(id));
        }
        }

@Override
public LineanegocioEntity update(LineanegocioEntity LineanegocioEntity) throws ResourceNotFoundException {
        if (repository.findById(LineanegocioEntity.getId()).isPresent())
        {
        return repository.save(LineanegocioEntity);
        }
        throw new ResourceNotFoundException("Lineanegocio", "id", Integer.toString(LineanegocioEntity.getId()));
        }

@Override
public ResultSearchData<LineanegocioEntity> findAllSearch(int page, int size) {
        Pageable paging = PageRequest.of(page, size );
        Page<LineanegocioEntity> pagedResult = repository.findAll(paging);
        return (ResultSearchData<LineanegocioEntity>) this.getResultSearch(pagedResult);
        }

        }
