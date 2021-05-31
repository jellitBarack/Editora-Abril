package com.abril.editora.service;

import com.abril.editora.entity.AssinaturaEndereco;
import com.abril.editora.entity.Pessoa;
import com.abril.editora.entity.TipoEndereco;
import com.abril.editora.exception.RecordNotFoundException;
import com.abril.editora.repository.AssinaturaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssinaturaEnderecoService {

    @Autowired
    AssinaturaEnderecoRepository repository;

    public List<AssinaturaEndereco> getAllByCepAndProductIdAndAddressTypeEntrega(String cep, Long productId){
        TipoEndereco.ENTREGA.name();
        List<AssinaturaEndereco> assinaturaEnderecoList = repository.getAllByCepAndProductIdAndAddressTypeEntrega(cep, productId, TipoEndereco.ENTREGA);

        if(assinaturaEnderecoList.size() > 0) {
            return assinaturaEnderecoList;
        } else {
            return new ArrayList<AssinaturaEndereco>(0);
        }
    }

    public List<AssinaturaEndereco> getAll(){
        List<AssinaturaEndereco> entityList = repository.findAll();

        if(entityList.size() > 0) {
            return entityList;
        } else {
            return new ArrayList<AssinaturaEndereco>();
        }
    }
    public AssinaturaEndereco getById(Long id) throws RecordNotFoundException {
        Optional<AssinaturaEndereco> entityOpt = repository.findById(id);
        if(entityOpt.isPresent()){
            return entityOpt.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public AssinaturaEndereco createOrUpdateUser(AssinaturaEndereco entity) throws RecordNotFoundException {
        long id = entity.getId() != null ? entity.getId() : 0l;
        Optional<AssinaturaEndereco> entityOpt = repository.findById(id);

        if(entityOpt.isPresent()){
            AssinaturaEndereco ae = entityOpt.get();
            ae.setAssinaturaId(entity.getAssinaturaId());
            ae.setCep(entity.getCep().replace("-",""));
            ae.setTipoEndereco(entity.getTipoEndereco());
            return repository.save(ae);
        } else {
            AssinaturaEndereco ae = new AssinaturaEndereco(entity.getAssinaturaId(), entity.getTipoEndereco(), entity.getCep().replace("-",""));
            return repository.save(ae);
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException{
        Optional<AssinaturaEndereco> entity = repository.findById(id);

        if(entity.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}
