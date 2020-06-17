package com.ito.notifico.lineanegocio.controller;
import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.LineanegocioEntity;
import com.ito.notifico.lineanegocio.service.ILineanegocioService;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({ "/lineanegocio-api" })
@CrossOrigin(origins= {"*"})
public class LineanegocioController {

    @Autowired
    private ILineanegocioService service;

    @GetMapping(value = "/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<LineanegocioEntity> create(@RequestBody LineanegocioEntity Lineanegocio) {
        return new ResponseEntity<>(service.create(Lineanegocio), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<LineanegocioEntity> findOne(@RequestParam int id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<LineanegocioEntity> update(@RequestBody LineanegocioEntity Lineanegocio) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.update(Lineanegocio), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody LineanegocioEntity Lineanegocio) throws ResourceNotFoundException {
        service.delete(Lineanegocio);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> delete(@RequestParam int id) throws ResourceNotFoundException {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<LineanegocioEntity>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ResultSearchData<LineanegocioEntity>> search(@RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "10") int size, @RequestParam(name = "sortBy") String sortBy
            , @RequestParam(name = "sortOrder") String sortOrder ) {
        ResultSearchData<LineanegocioEntity> datos = service.findAllSearch(page, size,sortBy, sortOrder);
        return new ResponseEntity<ResultSearchData<LineanegocioEntity>>(datos, new HttpHeaders(), HttpStatus.OK);

    }
}
