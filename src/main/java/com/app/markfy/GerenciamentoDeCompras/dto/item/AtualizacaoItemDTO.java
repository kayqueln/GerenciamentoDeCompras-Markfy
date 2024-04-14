package com.app.markfy.GerenciamentoDeCompras.dto.item;

import com.app.markfy.GerenciamentoDeCompras.model.enums.Tamanho;

public record AtualizacaoItemDTO(
        String nome,
        Float valor,
        String marca,
        Tamanho tamanho,
        Integer estoque
) {
}
