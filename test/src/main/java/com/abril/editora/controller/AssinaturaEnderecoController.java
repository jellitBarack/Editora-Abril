package com.abril.editora.controller;

import com.abril.editora.entity.Assinatura;
import com.abril.editora.entity.AssinaturaEndereco;
import com.abril.editora.entity.Pessoa;
import com.abril.editora.entity.User;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.service.AssinaturaEnderecoService;
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
@RequestMapping("/signature/address")
public class AssinaturaEnderecoController {

    @Autowired
    AssinaturaEnderecoService service;

    @ApiOperation(value = "Retorna uma lista de Endereco de Assinatura", response = AssinaturaEndereco.class, responseContainer = "List")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AssinaturaEndereco>> getAll() {
        List<AssinaturaEndereco> list = service.getAll();
        return new ResponseEntity<List<AssinaturaEndereco>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Salva um Endereco de Assinatura")
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AssinaturaEndereco> save(@RequestBody AssinaturaEndereco assinaturaEndereco) throws RecordNotFoundException {
        AssinaturaEndereco entity = service.createOrUpdateUser(assinaturaEndereco);
        return new ResponseEntity<AssinaturaEndereco>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra Endereco de Assinatura pelo Id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AssinaturaEndereco> getById(@PathVariable("id") Long id) throws RecordNotFoundException {
        AssinaturaEndereco entity = service.getById(id);
        return new ResponseEntity<AssinaturaEndereco>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta um Endereco de Assinatura pelo Id")
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpStatus deleteById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

    @ApiOperation(value = "Encontra todas as pessoas com assinatura pelo cep informado")
    @GetMapping(value = "/{cep}/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AssinaturaEndereco>> getAllByCepAndProductIdAndAddressTypeEntrega(@PathVariable("cep") String cep, @PathVariable("productId") Long productId) throws RecordNotFoundException {
        List<AssinaturaEndereco> entityList = service.getAllByCepAndProductIdAndAddressTypeEntrega(cep, productId);
        return new ResponseEntity<List<AssinaturaEndereco>>(entityList, new HttpHeaders(), HttpStatus.OK);
    }

}
