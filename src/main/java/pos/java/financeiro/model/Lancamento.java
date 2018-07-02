package pos.java.financeiro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;




@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Pessoa pessoa;
    private String descricao;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private Date dataVencimento;
    private Date dataPagamento;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id")
    public Pessoa getPessoa() {
        return pessoa;
    }

    @NotEmpty
    @Size(max = 80)
    @Column(length = 80, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    @NotNull
    @DecimalMin("0")
    @Column(precision = 10, scale = 2, nullable = false)
    public BigDecimal getValor() {
        return valor;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TipoLancamento getTipo() {
        return tipo;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento", nullable = false)
    public Date getDataVencimento() {
        return dataVencimento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento", nullable = true)
    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lancamento other = (Lancamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
