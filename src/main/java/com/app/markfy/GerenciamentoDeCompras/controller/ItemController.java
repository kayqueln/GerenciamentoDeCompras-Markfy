package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.item.AtualizacaoItemDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.item.CadastroItemDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.item.DetalhamentoItemDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Item;
import com.app.markfy.GerenciamentoDeCompras.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ErrorMessage error;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CadastroItemDTO cadastroItemDTO){
        try {
            DetalhamentoItemDTO item = itemService.cadastrarItem(cadastroItemDTO);
            return ResponseEntity.status(201).body(item);
        }catch (Exception e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<Item>> listar(){
        List<Item> items = itemService.listarItems();
        return ResponseEntity.status(200).body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            Item item = itemService.buscarItemPorId(id);
            return ResponseEntity.status(200).body(item);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody AtualizacaoItemDTO atualizacaoItemDTO){
        try {
            DetalhamentoItemDTO item = itemService.atualizarItem(id, atualizacaoItemDTO);
            return ResponseEntity.status(200).body(item);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        try {
            itemService.deletarItem(id);
            return ResponseEntity.status(204).build();
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }
}
