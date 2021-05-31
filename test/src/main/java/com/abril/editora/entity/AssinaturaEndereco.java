package com.abril.editora.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ApiModel
@Table(name="TBL_ASSINATURA_ENDERECO", indexes = @Index(name = "cep_index", columnList = "cep"))
public class AssinaturaEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Cod de Endereco de Assinatura", position = 1, notes = "used to display address signature id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="assinatura_id", referencedColumnName="id"),
            @JoinColumn(name="pessoa_id", referencedColumnName="pessoa_id"),
    })
    @ApiModelProperty(value = "Cod da Assinatura", position = 2, notes = "used to display signature id")
    private Assinatura assinaturaId;

    @Column(name="tipo_endereco")
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Tipo de Assinatura", position = 3, notes = "used to display signature type")
    private TipoEndereco tipoEndereco;

    @Column(name="cep")
    @ApiModelProperty(value = "Cep do Endereco de Assinatura", position = 4, notes = "used to display signature cep")
    private String cep;

    public AssinaturaEndereco(){}

    public AssinaturaEndereco(Long id, Assinatura assinaturaId, TipoEndereco tipoEndereco, String cep) {
        this.id = id;
        this.assinaturaId = assinaturaId;
        this.tipoEndereco = tipoEndereco;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Assinatura getAssinaturaId() {
        return assinaturaId;
    }

    public void setAssinaturaId(Assinatura assinaturaId) {
        this.assinaturaId = assinaturaId;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssinaturaEndereco)) return false;
        AssinaturaEndereco that = (AssinaturaEndereco) o;
        return Objects.equals(id, that.id) && Objects.equals(assinaturaId, that.assinaturaId) && tipoEndereco == that.tipoEndereco && Objects.equals(cep, that.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assinaturaId, tipoEndereco, cep);
    }

    @Override
    public String toString() {
        return "AssinaturaEndereco{" +
                "id=" + id +
                ", assinaturaId=" + assinaturaId +
                ", tipoEndereco=" + tipoEndereco +
                ", cep=" + cep +
                '}';
    }
}
