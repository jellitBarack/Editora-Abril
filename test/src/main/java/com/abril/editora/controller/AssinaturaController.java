package com.abril.editora.controller;

import com.abril.editora.entity.Assinatura;
import com.abril.editora.entity.User;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.service.AssinaturaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signature")
public class AssinaturaController {

    @Autowired
    AssinaturaService service;

    @ApiOperation(value = "Retorna uma lista de assinaturas", response = User.class, responseContainer = "List")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Assinatura>> getAll() {
        List<Assinatura> list = service.getAll();
        return new ResponseEntity<List<Assinatura>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Salva uma assinatura")
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Assinatura> save(@RequestBody Assinatura assinatura) throws RecordNotFoundException {
        Assinatura entity = service.createOrUpdateUser(assinatura);
        return new ResponseEntity<Assinatura>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra assinatura pelo Id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Assinatura> getById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Assinatura assinatura = service.getById(id);
        return new ResponseEntity<Assinatura>(assinatura, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta uma assinatura pelo Id")
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpStatus deleteById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

}
