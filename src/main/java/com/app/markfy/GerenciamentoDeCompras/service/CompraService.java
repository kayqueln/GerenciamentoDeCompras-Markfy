package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.compra.CadastroCompraDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.compra.DetalhamentoCompraDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import com.app.markfy.GerenciamentoDeCompras.model.Item;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private UsuarioService usuarioService;

    //IMPLEMENTAR VALOR TOTAL DA COMPRA
    public DetalhamentoCompraDTO cadastrarCompra(CadastroCompraDTO cadastroCompraDTO) throws Exception {
        try{
            Usuario usuario = usuarioService.buscarUsuarioPorId(cadastroCompraDTO.idUsuario());
            Compra compra = new Compra(usuario, cadastroCompraDTO.items());

            compraRepository.save(compra);
            DetalhamentoCompraDTO compraDTO = new DetalhamentoCompraDTO(compra);
            return compraDTO;
        }catch (NotFoundResourceException e){
            throw new Exception(e.getMessage()); 
        }
    }


    //ABAIXAR ESTOUE DO ITEM AUTOMATICAMENTE
    public DetalhamentoCompraDTO confirmarCompra(Long id) throws NotFoundResourceException {
        Optional<Compra> compra = compraRepository.findById(id);

        if(!compra.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar a compra");
        }

        compra.get().confirmarCompra();
        List<Item> items = compra.get().getItems();
        for(Item item : items){
            Integer estoque = item.getEstoque();
            Integer novoEstoque = estoque - 1;
            item.setEstoque(novoEstoque);
        }
        compraRepository.save(compra.get());

        DetalhamentoCompraDTO compraDTO = new DetalhamentoCompraDTO(compra.get());
        return compraDTO;
    }

    public List<DetalhamentoCompraDTO> listarCompras(){
        List<Compra> compras = compraRepository.findAll();
        List<DetalhamentoCompraDTO> comprasDetalhadas = new ArrayList<>();

        for(Compra compra : compras){
            DetalhamentoCompraDTO detalhamentoCompraDTO = new DetalhamentoCompraDTO(compra);
            comprasDetalhadas.add(detalhamentoCompraDTO);
        }


        return comprasDetalhadas;
    }

    public Compra buscarCompraPorId(Long id) throws NotFoundResourceException {
        Optional<Compra> compra = compraRepository.findById(id);

        if(!compra.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar a compra");
        }

        return compra.get();
    }

    public void deletarCompra(Long id) throws NotFoundResourceException {
        Optional<Compra> compra = compraRepository.findById(id);

        if(!compra.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar a compra");
        }

        compraRepository.delete(compra.get());
    }
}
