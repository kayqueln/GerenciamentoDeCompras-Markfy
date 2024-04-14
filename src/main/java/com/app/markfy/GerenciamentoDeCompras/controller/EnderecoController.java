package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.endereco.AtualizacaoEnderecoDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.endereco.CadastroEnderecoDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.endereco.DetalhamentoEnderecoDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Endereco;
import com.app.markfy.GerenciamentoDeCompras.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ErrorMessage error;
    @GetMapping
    public ResponseEntity<List<Endereco>> listar(){
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        return ResponseEntity.status(200).body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            Endereco endereco = enderecoService.buscarEnderecoPorId(id);
            return ResponseEntity.status(200).body(endereco);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody AtualizacaoEnderecoDTO atualizacaoEnderecoDTO){
        try {
            Endereco endereco = enderecoService.atualizarEndereco(id, atualizacaoEnderecoDTO);
            return ResponseEntity.status(200).body(endereco);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }
}
