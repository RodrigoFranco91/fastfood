package br.com.fastfood.application.adapter.rest.controller;


import br.com.fastfood.application.adapter.rest.dto.request.ProdutoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ProdutoResponseDTO;
import br.com.fastfood.application.port.ProdutoControllerPort;
import br.com.fastfood.domain.in.ProdutoServicePort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@RequestMapping("/produto")
@RestController
public class ProdutoController implements ProdutoControllerPort {

    private ProdutoServicePort produtoService;

    public ProdutoController(ProdutoServicePort produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrar(@RequestBody ProdutoDTO produtoDTO, HttpServletRequest request, UriComponentsBuilder uriBuilder) {

        var response = produtoService.cadastraProduto(produtoDTO);
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);

    }

    @GetMapping
    public ResponseEntity<Set<ProdutoResponseDTO>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarTodosProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> listarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(produtoService.listarProdutoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable UUID id) {
        produtoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable UUID id, @RequestBody ProdutoDTO produtoDTO) {
        var response = produtoService.atualizarProduto(id, produtoDTO);
        return ResponseEntity.ok(response);
    }
}
