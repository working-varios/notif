package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.ProductoEntity;
import com.ito.notifico.lineanegocio.repository.IProductoRepository;
import com.ito.notifico.lineanegocio.service.IGenericBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerProxy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IGenericBasicService<ProductoEntity> {
    @Autowired
    private IProductoRepository repository;

    @Override
    public ProductoEntity findByNombre(String nombre) throws ResourceNotFoundException {
        if (repository.findByNombre(nombre) == null) {
            return repository.findByNombre(nombre);
        } else {
            throw new ResourceNotFoundException("Producto", "nombre", nombre);
        }
    }

    public ProductoEntity findByCodigo(String codigo) throws ResourceNotFoundException {
        Optional <ProductoEntity> producto = repository.findByCodigo(codigo);
        return producto.orElseThrow( () -> new ResourceNotFoundException("Producto", "codigo", codigo));
    }

    @Override
    public Iterable<ProductoEntity> findAll() {
        List<ProductoEntity> lista = (List<ProductoEntity>) repository.findAll();
        return lista;
    }

    @Override
    public ProductoEntity findById(int id) throws ResourceNotFoundException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Producto", "id", Integer.toString(id));
        }
    }

}
