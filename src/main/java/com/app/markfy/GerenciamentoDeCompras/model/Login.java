package com.app.markfy.GerenciamentoDeCompras.model;

import com.app.markfy.GerenciamentoDeCompras.dto.login.CadastroLoginDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table
@Entity
@Data
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private LocalDate dataAcesso;

    @ManyToOne
    private Usuario usuario;

    public Login(String email, String senha, Usuario usuario) {
        this.email = email;
        this.senha = senha;
        this.dataAcesso = LocalDate.now();
        this.usuario = usuario;
    }
}
