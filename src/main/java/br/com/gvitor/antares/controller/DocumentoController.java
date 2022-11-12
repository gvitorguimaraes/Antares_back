package br.com.gvitor.antares.controller;

import br.com.gvitor.antares.model.Documento;
import br.com.gvitor.antares.service.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentoController {

    @Autowired
    private IDocumentoService service;

    @GetMapping("/documentos")
    public ResponseEntity<List<Documento>> listarDocumentos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/documentos/{id}")
    public ResponseEntity<Documento> atualizarDocumento(@RequestBody Documento docAtt, @PathVariable Integer id){
        docAtt.setId(id);
        Documento res = service.editarDocumento(docAtt);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/documentos/{id}")
    public ResponseEntity<Documento> consultaDocumento(@PathVariable Integer id){
        Documento res = service.consultaDocumento(id);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/documentos")
    public ResponseEntity<Documento> novoDocumento(@RequestBody Documento doc){
        Documento res = service.criarDocumento(doc);
        if(res != null)
            return ResponseEntity.status(201).body(doc);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/documentos/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id){
        service.excluirDocumento(id);
        return ResponseEntity.ok("Ok");
    }


}
