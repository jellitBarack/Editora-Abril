package com.abril.editora.controller;

import com.abril.editora.entity.User;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @ApiOperation(value = "Retorna uma lista de usuários", response = User.class, responseContainer = "List")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAllEmployees() {
        List<User> list = service.getAllUsers();
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Salva uma lista de usuários com nome e senha")
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getUserByNameAndPass(@RequestBody List<User> userList) throws RecordNotFoundException {
        List<User> savedUserList = new ArrayList<User>(0);
        for (User user:userList) {
            User entity = service.createOrUpdateUser(user);
            if(!savedUserList.contains(entity))
                savedUserList.add(entity);
        }
        return new ResponseEntity<List<User>>(savedUserList, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra um usuário pelo nome e senha")
    @GetMapping(value = "/{nome}/{pass}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUserByNameAndPass(@PathVariable("nome") String nome, @PathVariable("pass") String pass) throws RecordNotFoundException {
        User user = service.getUserByNameAndPass(nome, pass);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }
}
