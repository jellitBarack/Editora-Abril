package com.abril.editora.repository;

import com.abril.editora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.nome = :nome and u.pass = :pass")
    Optional<User> findByNameAndPass(@Param("nome") String nome, @Param("pass") String pass);
}
