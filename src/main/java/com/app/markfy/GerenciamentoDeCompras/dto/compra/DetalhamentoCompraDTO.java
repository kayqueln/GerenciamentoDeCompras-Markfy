package com.app.markfy.GerenciamentoDeCompras.dto.compra;

import com.app.markfy.GerenciamentoDeCompras.dto.usuario.DetalhamentoUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.usuario.DetalhamentoUsuarioSemEnderecoDTO;
import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import com.app.markfy.GerenciamentoDeCompras.model.Item;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public record DetalhamentoCompraDTO(
         Long id,
         LocalDate dataDaCompra,
         Boolean statusDaCompra,
         DetalhamentoUsuarioSemEnderecoDTO usuario,
         List<Item>itens
) {
    public DetalhamentoCompraDTO(Compra compra) {
        this(compra.getId(), compra.getDataDaCompra(), compra.getStatusDaCompra(), new DetalhamentoUsuarioSemEnderecoDTO(compra.getUsuario()), compra.getItems());
    }
}
