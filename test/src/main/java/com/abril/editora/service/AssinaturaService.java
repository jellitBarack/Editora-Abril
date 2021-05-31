package com.abril.editora.service;

import com.abril.editora.entity.Assinatura;
import com.abril.editora.entity.Pessoa;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.repository.AssinaturaRepository;
import com.abril.editora.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssinaturaService {

    @Autowired
    AssinaturaRepository repository;

    public List<Assinatura> getAll(){
        List<Assinatura> assinaturaList = repository.findAll();

        if(assinaturaList.size() > 0) {
            return assinaturaList;
        } else {
            return new ArrayList<Assinatura>();
        }
    }
    public Assinatura getById(Long id) throws RecordNotFoundException {
        Optional<Assinatura> assinaturaOpt = repository.findById(id);
        if(assinaturaOpt.isPresent()){
            return assinaturaOpt.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public Assinatura createOrUpdateUser(Assinatura entity) throws RecordNotFoundException {
        long id = entity.getId() != null ? entity.getId() : 0l;
        Optional<Assinatura> assinaturaOpt = repository.findById(id);

        if(assinaturaOpt.isPresent()){
            Assinatura assinatura = assinaturaOpt.get();
            assinatura.setPessoaId(entity.getPessoaId());
            assinatura.setProdutoId(entity.getProdutoId());
            return repository.save(assinatura);
        } else {
            Assinatura assinatura = new Assinatura(entity.getPessoaId(), entity.getProdutoId());
            return repository.save(assinatura);
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException{
        Optional<Assinatura> assinatura = repository.findById(id);

        if(assinatura.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}
