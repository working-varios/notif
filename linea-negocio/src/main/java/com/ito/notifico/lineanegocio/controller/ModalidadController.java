package com.ito.notifico.lineanegocio.controller;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.ModalidadEntity;
import com.ito.notifico.lineanegocio.service.implementaciones.ModalidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({ "/modalidad-api" })
@CrossOrigin(origins= {"*"})
public class ModalidadController {

    @Autowired
    private ModalidadServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<ModalidadEntity> create(@RequestBody ModalidadEntity modalidad
            , @RequestHeader("Authorization") int usuarioId)
    {
        return new ResponseEntity<>(service.create(modalidad), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<ModalidadEntity> findOne(@RequestParam int id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ModalidadEntity> update(@RequestBody ModalidadEntity modalidad
            , @RequestHeader("Authorization") int usuarioId
    ) throws ResourceNotFoundException
    {
        return new ResponseEntity<>(service.update(modalidad), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody ModalidadEntity Modalidad) throws ResourceNotFoundException {
        service.delete(Modalidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") int id) throws ResourceNotFoundException {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<ModalidadEntity>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
