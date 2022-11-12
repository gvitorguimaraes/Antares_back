package br.com.gvitor.antares.services;

import br.com.gvitor.antares.dao.IItemDocRep;
import br.com.gvitor.antares.model.Documento;
import br.com.gvitor.antares.model.ItemDocumento;
import br.com.gvitor.antares.model.Produto;
import br.com.gvitor.antares.service.ItemDocServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemDocTests {

    @InjectMocks
    private ItemDocServiceImpl servico;
    @Mock
    private IItemDocRep repositorio;
    private ItemDocumento novoItem;
    private ItemDocumento itemCriado;

    @BeforeEach
    public void setup(){
        novoItem = new ItemDocumento();
        novoItem.setDocumento(new Documento());
        novoItem.setProduto(new Produto());

        itemCriado = new ItemDocumento();
        itemCriado.setNumSeq(1);
        itemCriado.setDocumento(novoItem.getDocumento());
        itemCriado.setProduto(novoItem.getProduto());

        Mockito.when(repositorio.save(novoItem)).thenReturn(itemCriado);

    }

    @Test
    public void testNovoItem(){
        assertEquals(servico.novoItem(novoItem), itemCriado);
    }

    @Test
    public void testEditarItem(){
        assertEquals(servico.editarItem(novoItem), itemCriado);
    }
}
