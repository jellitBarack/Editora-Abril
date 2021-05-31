package com.abril.editora.repository;

import com.abril.editora.entity.AssinaturaEndereco;
import com.abril.editora.entity.Pessoa;
import com.abril.editora.entity.TipoEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssinaturaEnderecoRepository extends JpaRepository<AssinaturaEndereco, Long> {

    @Query("select ae from AssinaturaEndereco ae " +
            "inner join Assinatura a on ae.assinaturaId = a.id " +
            "where ae.cep = :cep " +
            "and a.produtoId = :productId " +
            "and ae.tipoEndereco = :tipoEndereco ")
    List<AssinaturaEndereco> getAllByCepAndProductIdAndAddressTypeEntrega(@Param("cep") String cep, @Param("productId") Long productId, @Param("tipoEndereco") TipoEndereco tipoEndereco);
}
