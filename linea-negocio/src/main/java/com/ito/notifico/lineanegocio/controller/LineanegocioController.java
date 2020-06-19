package com.ito.notifico.lineanegocio.controller;
import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.LineanegocioEntity;
import com.ito.notifico.lineanegocio.service.ILineanegocioService;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/lineanegocio-api" })
@CrossOrigin(origins= {"*"})
public class LineanegocioController {

    @Autowired
    private ILineanegocioService service;

  //  @RequestMapping(method = RequestMethod.POST, path = "/create")
    @PostMapping("/create")
    public ResponseEntity<LineanegocioEntity> create(@RequestBody LineanegocioEntity lineanegocio
            , @RequestHeader("Authorization") int usuarioId)
    {
        lineanegocio.setUsuarioid(usuarioId);
        return new ResponseEntity<>(service.create(lineanegocio), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<LineanegocioEntity> findOne(@RequestParam int id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
//    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<LineanegocioEntity> update(@RequestBody LineanegocioEntity lineanegocio
            , @RequestHeader("Authorization") int usuarioId
        ) throws ResourceNotFoundException
    {
        lineanegocio.setUsuarioid(usuarioId);
        return new ResponseEntity<>(service.update(lineanegocio), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody LineanegocioEntity Lineanegocio) throws ResourceNotFoundException {
        service.delete(Lineanegocio);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteById")
    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") int id) throws ResourceNotFoundException {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
//    @RequestMapping(method = RequestMethod.GET, path = "/findAll")
    public ResponseEntity<Iterable<LineanegocioEntity>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    //@RequestMapping(method = RequestMethod.GET, path = "/search")
    public ResponseEntity<ResultSearchData<LineanegocioEntity>> search(@RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "10") int size, @RequestParam(name = "sortBy") String sortBy
            , @RequestParam(name = "sortOrder") String sortOrder
            , @RequestHeader("Authorization") int usuarioId
    ) {
        ResultSearchData<LineanegocioEntity> datos = service.findAllSearch(page, size,sortBy, sortOrder, usuarioId);
        return new ResponseEntity<ResultSearchData<LineanegocioEntity>>(datos, new HttpHeaders(), HttpStatus.OK);
    }
}
