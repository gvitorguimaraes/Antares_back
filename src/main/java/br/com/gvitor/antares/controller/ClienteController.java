package br.com.gvitor.antares.controller;

import br.com.gvitor.antares.model.Cliente;
import br.com.gvitor.antares.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService service;

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> criarNovo(@RequestBody Cliente novoCliente){
        Cliente cliente = service.cadastraCliente(novoCliente);
        if(cliente != null){
            return ResponseEntity.status(201).body(cliente);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(service.listarClientes());
    }

    @GetMapping("/cliente/search")
    public ResponseEntity<List<Cliente>> buscarPalavraChave(@RequestParam(name = "k")String chave){
        return ResponseEntity.ok(service.consultarClientePalavraChave(chave));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> buscarId(@PathVariable Integer id){
        Cliente cliente = service.consultarCliente(id);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

}
