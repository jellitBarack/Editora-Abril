package com.abril.editora.repository;

import com.abril.editora.entity.Assinatura;
import com.abril.editora.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {

}
