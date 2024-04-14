package com.app.markfy.GerenciamentoDeCompras.dto.item;

import com.app.markfy.GerenciamentoDeCompras.model.Item;

public record DetalhamentoItemDTO(
         Long id,
         String nome,
         Float valor,
         String marca,
         Integer estoque
) {

    public DetalhamentoItemDTO(Item item) {
        this(item.getId(), item.getNome(), item.getValor(), item.getMarca(), item.getEstoque());
    }
}
