package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.usuario.AtualizacaoUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.usuario.CadastroUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.usuario.DetalhamentoUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ErrorMessage error;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CadastroUsuarioDTO cadastroUsuarioDTO){
        try {
            DetalhamentoUsuarioDTO usuario = usuarioService.cadastrarUsuario(cadastroUsuarioDTO);
            return ResponseEntity.status(201).body(usuario);
        }catch (Exception e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            Usuario usuario = usuarioService.buscarUsuarioPorId(id);
            return ResponseEntity.status(200).body(usuario);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody AtualizacaoUsuarioDTO atualizacaoUsuarioDTO){
        try {
            DetalhamentoUsuarioDTO usuario = usuarioService.atualizarUsuario(id, atualizacaoUsuarioDTO);
            return ResponseEntity.status(200).body(usuario);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.status(204).build();
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }
}
