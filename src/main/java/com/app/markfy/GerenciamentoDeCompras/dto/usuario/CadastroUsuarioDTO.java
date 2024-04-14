package com.app.markfy.GerenciamentoDeCompras.dto.usuario;
import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import com.app.markfy.GerenciamentoDeCompras.model.Endereco;
import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivil;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacional;
import com.app.markfy.GerenciamentoDeCompras.model.enums.Ocupacao;
import com.app.markfy.GerenciamentoDeCompras.model.enums.Sexo;

import java.time.LocalDate;
import java.util.List;

public record CadastroUsuarioDTO(
        String nome,
        LocalDate dataDeNasciemto,
        String email,
        String senha,
        Sexo sexo,
        String cpf,
        EstadoCivil estadoCivil,
        NivelEducacional nivelEducacional,
        Float rendaAnual,
        Ocupacao ocupacao,
        Endereco endereco,
        List<Compra> compras
) {
}
