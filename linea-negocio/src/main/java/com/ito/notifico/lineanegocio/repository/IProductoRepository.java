package com.ito.notifico.lineanegocio.repository;

import com.ito.notifico.lineanegocio.model.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface IProductoRepository extends CrudRepository<ProductoEntity,Integer> {
    Page<ProductoEntity> findAll(Pageable paging);
    ProductoEntity findByNombre(String nombre);

    Optional<ProductoEntity> findByCodigo(String codigo);
    //@Query(value = "SELECT id,nombre, codigo, eliminado, activo, clase_id FROM producto WHERE codigo =:codigo AND eliminado is null", nativeQuery = true)
    //ProductoEntity findByCodigo(@Param("codigo") String codigo);

}
