package com.abril.editora.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ApiModel
@Table(name="TBL_ASSINATURA")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Cod de Assinatura", position = 1, notes = "used to display signature id")
    private Long id;

    @Column(name="pessoa_id")
    @ApiModelProperty(value = "Cod da Pessoa", position = 2, notes = "used to display people")
    private Pessoa pessoa;

    @Column(name="produto_id")
    @ApiModelProperty(value = "Cod do Produto", position = 3, notes = "used to display product id")
    private Long produtoId;

    public Assinatura(){}

    public Assinatura(Long id, Pessoa pessoa, Long produtoId) {
        this.id = id;
        this.pessoa = pessoa;
        this.produtoId = produtoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assinatura)) return false;
        Assinatura that = (Assinatura) o;
        return Objects.equals(id, that.id) && Objects.equals(pessoa, that.pessoa) && Objects.equals(produtoId, that.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pessoa, produtoId);
    }

    @Override
    public String toString() {
        return "Assinatura{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", produtoId=" + produtoId +
                '}';
    }
}
