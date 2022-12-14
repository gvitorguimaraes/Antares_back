package br.com.gvitor.antares.controller;

import br.com.gvitor.antares.model.Produto;
import br.com.gvitor.antares.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private IProdutoService service;

    @PostMapping("/produtos")
    public ResponseEntity<Produto> novoProduto(@RequestBody Produto novoProduto){
        Produto prod = service.criarNovoProduto(novoProduto);
        if (prod != null){
            return ResponseEntity.status(201).body(prod);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.ok(service.listarProdutos());
    }

    @GetMapping("/produtos/search")
    public ResponseEntity<List<Produto>> consultaPalavraChave(@RequestParam(name = "k") String chave){
        return ResponseEntity.ok(service.buscarProdutoPorChave(chave));
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> consultaId(@PathVariable Integer id){
        Produto prod = service.buscarPorId(id);
        if(prod != null){
            return ResponseEntity.ok(prod);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> removerProduto(@PathVariable Integer id){
        service.removerProduto(id);
        return ResponseEntity.ok("Ok");
    }
}
