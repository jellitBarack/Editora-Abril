package com.abril.editora.service;

import com.abril.editora.entity.Pessoa;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> getAll(){
        List<Pessoa> pessoaList = repository.findAll();

        if(pessoaList.size() > 0) {
            return pessoaList;
        } else {
            return new ArrayList<Pessoa>();
        }
    }

    public Pessoa createOrUpdateUser(Pessoa entity) throws RecordNotFoundException {
        long id = entity.getId() != null ? entity.getId() : 0l;
        Optional<Pessoa> pessoaOpt = repository.findById(id);

        if(pessoaOpt.isPresent()){
            Pessoa pessoa = pessoaOpt.get();
            pessoa.setNome(entity.getNome());
            return repository.save(pessoa);
        } else {
            Pessoa pessoa = new Pessoa(entity.getNome());
            return repository.save(pessoa);
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException{
        Optional<Pessoa> pessoa = repository.findById(id);

        if(pessoa.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}
