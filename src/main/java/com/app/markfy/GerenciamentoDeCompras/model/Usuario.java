package com.app.markfy.GerenciamentoDeCompras.model;

import com.app.markfy.GerenciamentoDeCompras.dto.usuario.AtualizacaoUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.usuario.CadastroUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivil;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacional;
import com.app.markfy.GerenciamentoDeCompras.model.enums.Ocupacao;
import com.app.markfy.GerenciamentoDeCompras.model.enums.Sexo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeNasciemto;
    private String email;
    private String senha;
    private Sexo sexo;
    //bater em api para buscar dados com o cpf
    private String cpf;
    private EstadoCivil estadoCivil;
    private NivelEducacional nivelEducacional;
    private Float rendaAnual;
    private Ocupacao ocupacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Compra> compras;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Login> logins;

    public Usuario(CadastroUsuarioDTO cadastroUsuarioDTO) {
        this.nome = cadastroUsuarioDTO.nome();
        this.dataDeNasciemto = cadastroUsuarioDTO.dataDeNasciemto();
        this.email = cadastroUsuarioDTO.email();
        this.senha = cadastroUsuarioDTO.senha();
        this.sexo = cadastroUsuarioDTO.sexo();
        this.cpf = cadastroUsuarioDTO.cpf();
        this.estadoCivil = cadastroUsuarioDTO.estadoCivil();
        this.nivelEducacional = cadastroUsuarioDTO.nivelEducacional();
        this.rendaAnual = cadastroUsuarioDTO.rendaAnual();
        this.ocupacao = cadastroUsuarioDTO.ocupacao();
        this.endereco = cadastroUsuarioDTO.endereco();
        this.compras = cadastroUsuarioDTO.compras();
    }

    public void atualizarUsuario(AtualizacaoUsuarioDTO atualizacaoUsuarioDTO) {
        if(atualizacaoUsuarioDTO.nome() != null) this.nome = atualizacaoUsuarioDTO.nome();
        if(atualizacaoUsuarioDTO.dataDeNasciemto() != null) this.dataDeNasciemto = atualizacaoUsuarioDTO.dataDeNasciemto();
        if(atualizacaoUsuarioDTO.email() != null) this.email = atualizacaoUsuarioDTO.email();
        if(atualizacaoUsuarioDTO.senha() != null) this.senha = atualizacaoUsuarioDTO.senha();
        if(atualizacaoUsuarioDTO.sexo() != null) this.sexo = atualizacaoUsuarioDTO.sexo();
        if(atualizacaoUsuarioDTO.cpf() != null) this.cpf = atualizacaoUsuarioDTO.cpf();
        if(atualizacaoUsuarioDTO.estadoCivil() != null) this.estadoCivil = atualizacaoUsuarioDTO.estadoCivil();
        if(atualizacaoUsuarioDTO.nivelEducacional() != null) this.nivelEducacional = atualizacaoUsuarioDTO.nivelEducacional();
        if(atualizacaoUsuarioDTO.rendaAnual() != null) this.rendaAnual = atualizacaoUsuarioDTO.rendaAnual();
        if(atualizacaoUsuarioDTO.ocupacao() != null) this.ocupacao = atualizacaoUsuarioDTO.ocupacao();
    }
}
