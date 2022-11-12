package br.com.gvitor.antares.controller;

import br.com.gvitor.antares.dao.IItemDocRep;
import br.com.gvitor.antares.model.ItemDocumento;
import br.com.gvitor.antares.service.IItemDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemDocController {
    @Autowired
    private IItemDocService service;

    @PostMapping("/itemDocumento")
    public ResponseEntity<ItemDocumento> novoItem(@RequestBody ItemDocumento doc){
        ItemDocumento res = service.novoItem(doc);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/itemDocumento/{numSeq}")
    public ResponseEntity<ItemDocumento> atualizarItem(@RequestBody ItemDocumento itemAtt, @PathVariable Integer numSeq){
        itemAtt.setNumSeq(numSeq);
        ItemDocumento res = service.editarItem(itemAtt);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/itemDocumento/{numSeq}")
    public ResponseEntity<?> remover(@PathVariable Integer numSeq){
        service.excluirItem(numSeq);
        return ResponseEntity.ok("Ok");
    }
}
