package com.abril.editora.service;

import com.abril.editora.entity.AssinaturaEndereco;
import com.abril.editora.entity.Pessoa;
import com.abril.editora.repository.AssinaturaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssinaturaEnderecoService {

    @Autowired
    AssinaturaEnderecoRepository assinaturaEnderecoRepository;

    public List<Pessoa> getAllByCepAndAddressTypeEntrega(String cep){
        List<AssinaturaEndereco> assinaturaEnderecoList = assinaturaEnderecoRepository.getAllByCepAndAddressTypeEntrega(cep);

        if(assinaturaEnderecoList.size() > 0) {
            List<Pessoa> pessoaList = new ArrayList<Pessoa>(0);
            for (AssinaturaEndereco ae:assinaturaEnderecoList) {
                if(!pessoaList.contains(ae.getAssinaturaId().getPessoa()))
                    pessoaList.add(ae.getAssinaturaId().getPessoa());
            }
            return pessoaList;
        } else {
            return new ArrayList<Pessoa>(0);
        }
    }
}
