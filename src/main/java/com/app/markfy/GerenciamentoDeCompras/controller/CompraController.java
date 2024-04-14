package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.compra.AtualizacaoCompraDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.compra.CadastroCompraDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.compra.DetalhamentoCompraDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import com.app.markfy.GerenciamentoDeCompras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private CompraService compraService;
    @Autowired
    private ErrorMessage error;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CadastroCompraDTO cadastroCompraDTO){
        try {
            DetalhamentoCompraDTO compra = compraService.cadastrarCompra(cadastroCompraDTO);
            return ResponseEntity.status(201).body(compra);
        }catch (Exception e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity confirmarCompra(@PathVariable Long id){
        try {
            DetalhamentoCompraDTO compra = compraService.confirmarCompra(id);
            return ResponseEntity.status(200).body(compra);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<DetalhamentoCompraDTO>> listar(){
        List<DetalhamentoCompraDTO> compras = compraService.listarCompras();
        return ResponseEntity.status(200).body(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            Compra compra = compraService.buscarCompraPorId(id);
            return ResponseEntity.status(200).body(compra);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        try {
            compraService.deletarCompra(id);
            return ResponseEntity.status(204).build();
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }
}
