package com.ito.notifico.lineanegocio.controller;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.MunicipioEntity;
import com.ito.notifico.lineanegocio.service.IGenericNoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({ "/municipio-api" })
@CrossOrigin(origins= {"*"})
public class MunicipioController {

    @Autowired
    private IGenericNoPageService<MunicipioEntity> service;

    @PostMapping("/create")
    public ResponseEntity<MunicipioEntity> create(@RequestBody MunicipioEntity modalidad
            , @RequestHeader("Authorization") int usuarioId)
    {
        return new ResponseEntity<>(service.create(modalidad), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<MunicipioEntity> findOne(@RequestParam int id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<MunicipioEntity> update(@RequestBody MunicipioEntity modalidad
            , @RequestHeader("Authorization") int usuarioId
    ) throws ResourceNotFoundException
    {
        return new ResponseEntity<>(service.update(modalidad), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody MunicipioEntity Ubicacion) throws ResourceNotFoundException {
        service.delete(Ubicacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") int id) throws ResourceNotFoundException {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<MunicipioEntity>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
