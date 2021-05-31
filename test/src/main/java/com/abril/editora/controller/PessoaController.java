package com.abril.editora.controller;

import com.abril.editora.entity.Pessoa;
import com.abril.editora.entity.User;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.service.AssinaturaEnderecoService;
import com.abril.editora.service.PessoaService;
import com.abril.editora.service.UserService;
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

    @Autowired
    AssinaturaEnderecoService aeService;

    @ApiOperation(value = "Retorna uma lista de pessoas", response = User.class, responseContainer = "List")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Pessoa>> getAllEmployees() {
        List<Pessoa> list = service.getAll();
        return new ResponseEntity<List<Pessoa>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Salva uma pessoa com nome")
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Pessoa> getUserByNameAndPass(@RequestBody Pessoa pessoa) throws RecordNotFoundException {
        Pessoa entity = service.createOrUpdateUser(pessoa);
        return new ResponseEntity<Pessoa>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra um usuário pelo nome e senha")
    @GetMapping(value = "/{cep}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Pessoa>> getUserByNameAndPass(@PathVariable("cep") String cep) throws RecordNotFoundException {
        List<Pessoa> pessoaList = aeService.getAllByCepAndAddressTypeEntrega(cep);
        return new ResponseEntity<List<Pessoa>>(pessoaList, new HttpHeaders(), HttpStatus.OK);
    }

}
