package com.ito.notifico.lineanegocio.controller;
import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.GrupoEntity;
import com.ito.notifico.lineanegocio.service.IGrupoService;
import com.ito.notifico.lineanegocio.shared.ResultSearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({ "/grupo-api" })
@CrossOrigin(origins = "*")
public class GrupoController {

    @Autowired
    private IGrupoService service;

    @GetMapping(value = "/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<GrupoEntity> create(@RequestBody GrupoEntity grupo) {
        return new ResponseEntity<>(service.create(grupo), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<GrupoEntity> findOne(@RequestParam int id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<GrupoEntity> update(@RequestBody GrupoEntity grupo) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.update(grupo), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody GrupoEntity grupo) throws ResourceNotFoundException {
        service.delete(grupo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> delete(@RequestParam int id) throws ResourceNotFoundException {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<GrupoEntity>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    /*@GetMapping
    public Page<GrupoDtoPagination> search(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<GrupoDto> list = service.findAll(pageRequest);

        List<GrupoDtoPagination> todos = pageResult
                .stream()
                .map(TodoResponse::new)
                .collect(toList());

        return new PageImpl<>(todos, pageRequest, pageResult.getTotalElements());

    }*/

    @GetMapping("/search")
    public ResponseEntity<ResultSearchData<GrupoEntity>> search(@RequestParam(name = "pageIndex", defaultValue = "0") int pageIndex,
                                                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        //PageRequest pageRequest = PageRequest.of(page, size);
        ResultSearchData<GrupoEntity> datos = service.findAllSearch(pageIndex, pageSize);
        return new ResponseEntity<ResultSearchData<GrupoEntity>>(datos, new HttpHeaders(), HttpStatus.OK);

    }
}
