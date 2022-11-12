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

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> novoCliente(@RequestBody Cliente novoCliente){
        Cliente cliente = service.cadastraCliente(novoCliente);
        if(cliente != null){
            return ResponseEntity.status(201).body(cliente);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente clienteAtt, @PathVariable Integer id){
        clienteAtt.setId(id);
        Cliente res = service.editarCliente(clienteAtt);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(service.listarClientes());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> consultaId(@PathVariable Integer id){
        Cliente cliente = service.consultarCliente(id);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clientes/search")
    public ResponseEntity<List<Cliente>> consultaPalavraChave(@RequestParam(name = "k")String chave){
        return ResponseEntity.ok(service.consultarClientePalavraChave(chave));
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id){
        service.removerCliente(id);
        return ResponseEntity.ok("Ok");
    }


}
