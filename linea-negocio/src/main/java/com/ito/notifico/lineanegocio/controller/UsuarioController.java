package com.ito.notifico.lineanegocio.controller;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping({"/usuario-api"})
@CrossOrigin(origins = {"*"})
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/findByUserAndPassword")
    public ResponseEntity<Object> findByUserAndPassword(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password)
            throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findByUsernameAndPassword(username, password),HttpStatus.OK);
    }
}

