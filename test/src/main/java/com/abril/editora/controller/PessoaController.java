package com.abril.editora.controller;

import com.abril.editora.entity.Assinatura;
import com.abril.editora.entity.Pessoa;
import com.abril.editora.entity.User;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.service.AssinaturaEnderecoService;
import com.abril.editora.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PessoaController {

    @Autowired
    PessoaService service;

    @ApiOperation(value = "Retorna uma lista de pessoas", response = User.class, responseContainer = "List")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> list = service.getAll();
        return new ResponseEntity<List<Pessoa>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Salva uma pessoa")
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) throws RecordNotFoundException {
        Pessoa entity = service.createOrUpdateUser(pessoa);
        return new ResponseEntity<Pessoa>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra assinatura pelo Id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Pessoa> getById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Pessoa entity = service.getById(id);
        return new ResponseEntity<Pessoa>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta uma pessoa pelo Id")
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpStatus deleteById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

}
