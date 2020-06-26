package com.ito.notifico.lineanegocio.controller;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.ProductoEntity;
import com.ito.notifico.lineanegocio.service.IGenericBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({ "/producto-api" })
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private IGenericBasicService<ProductoEntity> service;

    @GetMapping("/findById")
    public ResponseEntity<ProductoEntity> findOne(@RequestParam int id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByCodigo")
    public ResponseEntity<ProductoEntity> findByCodigo(@RequestParam String codigo) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findByCodigo(codigo), HttpStatus.OK);
    }

}
