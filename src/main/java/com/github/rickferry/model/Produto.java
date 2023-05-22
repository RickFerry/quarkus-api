package com.github.rickferry.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.rickferry.model.dto.CadastroProdutoDTO;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Produto extends PanacheEntity{
    
    public String nome;
    public BigDecimal valor;
    
    @CreationTimestamp
    public LocalDate dataCriacao;
    
    @UpdateTimestamp
    public LocalDate dataAtualizacao;
    
    public Produto() {}

    public Produto(CadastroProdutoDTO dto) {
        this.nome = dto.nome();
        this.valor = dto.valor();
        this.dataCriacao = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }
}
