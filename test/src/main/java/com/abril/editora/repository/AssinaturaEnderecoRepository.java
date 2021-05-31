package com.abril.editora.repository;

import com.abril.editora.entity.AssinaturaEndereco;
import com.abril.editora.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssinaturaEnderecoRepository extends JpaRepository<AssinaturaEndereco, Long> {

    @Query("select ae from AssinaturaEndereco ae " +
            "inner join ae.assinaturaId a " +
            "where ae.tipoEndereco = 'ENTREGA' " +
            "and ae.cep = :cep " +
            "and a.produtoId = 55")
    List<AssinaturaEndereco> getAllByCepAndAddressTypeEntrega(@Param("cep") String cep);
}
