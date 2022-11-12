package br.com.gvitor.antares.service;

import br.com.gvitor.antares.model.Documento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDocumentoService {
    public Documento criarDocumento(Documento doc);
    public Documento editarDocumento(Documento doc);
    public Documento consultaDocumento(Integer id);
    public void excluirDocumento(Integer id);
    public void imprimirDocumento(Documento doc);

    public List<Documento> listarTodos();
}
