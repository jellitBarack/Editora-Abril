package com.abril.editora.entity;

import com.abril.editora.util.Criptografia;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@ApiModel
@Table(name="TBL_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden=true)
    private Long id;

    @Column(name="name")
    @NotNull(message = "Name cannot be null")
    @ApiModelProperty(value = "Nome do usuário", position = 1, required = true, notes = "used to display user name")
    private String nome;

    @Column(name="pass")
    @NotNull(message = "Pass cannot be null")
    @ApiModelProperty(value = "Senha do usuário", position = 2, required = true, notes = "used to display user pass")
    private String pass;

    public User (){}

    public User (String nome, String pass){
        this.nome = nome;
        this.pass = pass;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = Criptografia.encodedHex(pass);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
