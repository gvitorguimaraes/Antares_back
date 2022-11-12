package br.com.gvitor.antares.service;

import br.com.gvitor.antares.dao.IDocumentoRep;
import br.com.gvitor.antares.model.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoServiceImpl implements IDocumentoService{
    @Autowired
    private IDocumentoRep repo;
    @Override
    public Documento criarDocumento(Documento doc) {
        return repo.save(doc);
    }
    @Override
    public Documento editarDocumento(Documento doc) {
        return repo.save(doc);
    }
    @Override
    public Documento consultaDocumento(Integer id) {
        return repo.findById(id).orElse(null);
    }
    @Override
    public void excluirDocumento(Integer id) {
        repo.deleteById(id);
    }
    @Override
    public void imprimirDocumento(Documento doc) {  //***************
    }
    @Override
    public List<Documento> listarTodos() {
        return (List<Documento>)repo.findAll();
    }
}
