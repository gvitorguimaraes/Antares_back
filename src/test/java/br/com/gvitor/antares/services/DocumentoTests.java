package br.com.gvitor.antares.services;

import br.com.gvitor.antares.dao.IDocumentoRep;
import br.com.gvitor.antares.model.Cliente;
import br.com.gvitor.antares.model.Documento;
import br.com.gvitor.antares.service.DocumentoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DocumentoTests {

    @InjectMocks
    private DocumentoServiceImpl service;
    @Mock
    private IDocumentoRep repositorio;

    private Integer existingId = 1;
    private Integer nonExistingId = 20;
    private Documento novoDoc;
    private Documento docCriado;
    private ArrayList<Documento> listaDocumentos;

    @BeforeEach
    public void setup(){
        novoDoc = new Documento();
        novoDoc.setCliente(new Cliente());
        novoDoc.setData(LocalDate.now());

        docCriado = new Documento();
        docCriado.setId(1);
        docCriado.setCliente(new Cliente());
        docCriado.setData(LocalDate.now());

        listaDocumentos = new ArrayList<Documento>();
        Documento doc1, doc2;
        doc1 = new Documento();
        doc1.setId(2);
        doc1.setCliente(new Cliente());
        doc1.setData(LocalDate.now());
        listaDocumentos.add(doc1);

        doc2 = new Documento();
        doc2.setId(3);
        doc2.setCliente(new Cliente());
        doc2.setData(LocalDate.now());
        listaDocumentos.add(doc2);

        Mockito.when(repositorio.save(novoDoc)).thenReturn(docCriado);
        Mockito.when(repositorio.findById(existingId)).thenReturn(Optional.of(new Documento()));
        Mockito.when(repositorio.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
        Mockito.when(repositorio.findAll()).thenReturn(listaDocumentos);
    }

    @Test
    public void testCriarDocumento(){
        assertEquals(service.criarDocumento(novoDoc), docCriado);
    }

    @Test
    public void testEditarDocumento(){
        assertEquals(service.editarDocumento(novoDoc), docCriado);
    }

    @Test
    public void testConsultarDocumentoFind(){
        assertNotNull(service.consultaDocumento(existingId));
    }
    @Test
    public void testConsultarDocumentoNotFind(){
        assertNull(service.consultaDocumento(nonExistingId));
    }
    @Test
    public void testListarTodos(){
        assertEquals(service.listarTodos(), listaDocumentos);
    }
}
