package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.login.CadastroLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.login.DetalhamentoLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.LoginException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Login;
import com.app.markfy.GerenciamentoDeCompras.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private ErrorMessage error;

    @PostMapping
    public ResponseEntity logar(@RequestBody CadastroLoginDTO cadastroLoginDTO){
        try {
            DetalhamentoLoginDTO login = loginService.logar(cadastroLoginDTO);
            return ResponseEntity.status(201).body(login);
        }catch (LoginException | NotFoundResourceException | Exception e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<DetalhamentoLoginDTO>> listar(){
        List<DetalhamentoLoginDTO> logins = loginService.listarLogins();
        return ResponseEntity.status(200).body(logins);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            DetalhamentoLoginDTO login = loginService.buscarLoginPorId(id);
            return ResponseEntity.status(200).body(login);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }
}
