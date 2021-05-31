package com.abril.editora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abril.editora.entity.User;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.repository.UserRepository;
import com.abril.editora.util.Criptografia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     
    @Autowired
    UserRepository repository;
     
    public List<User> getAllUsers(){
        List<User> userList = repository.findAll();
         
        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }
    }
     
    public User getUserByNameAndPass(String nome, String pass) throws RecordNotFoundException{
        String passEncoded = Criptografia.encodedHex(pass);
        Optional<User> user = repository.findByNameAndPass(nome, passEncoded);
         
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given name and pass");
        }
    }
     
    public User createOrUpdateUser(User entity) throws RecordNotFoundException{
        long id = entity.getId() != null ? entity.getId() : 0l;
        Optional<User> userOpt = repository.findById(id);
         
        if(userOpt.isPresent()){
            User user = userOpt.get();
            user.setNome(entity.getNome());
            user.setPass(entity.getPass());
            return repository.save(user);
        } else {
            User user = new User(entity.getNome(), entity.getPass());
            return repository.save(user);
        }
    }
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException{
        Optional<User> user = repository.findById(id);
         
        if(user.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}