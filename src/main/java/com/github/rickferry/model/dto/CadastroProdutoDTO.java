package com.github.rickferry.model.dto;

import java.math.BigDecimal;

public record CadastroProdutoDTO(
    String nome,
    BigDecimal valor) {}
