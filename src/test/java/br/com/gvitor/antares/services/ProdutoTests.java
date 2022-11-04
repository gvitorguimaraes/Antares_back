package br.com.gvitor.antares.services;

import br.com.gvitor.antares.dao.IProdutoRep;
import br.com.gvitor.antares.model.Produto;
import br.com.gvitor.antares.service.IProdutoService;
import br.com.gvitor.antares.service.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoTests {
    @InjectMocks
    private ProdutoServiceImpl servico;
    @Mock
    private IProdutoRep repositorio;

    private Integer existingId = 1;
    private Integer nonExistingId = 100;
    private String keyword = "pao";
    private Produto newProduto;
    private Produto createdProduto;
    private ArrayList<Produto> listaProdutos;

    @BeforeEach
    public void setup() throws Exception{
        newProduto = new Produto();
        newProduto.setNome("pao");

        createdProduto = new Produto();
        createdProduto.setId(1);
        createdProduto.setNome("pao");

        listaProdutos = new ArrayList<Produto>();
        Produto p1, p2;
        p1 = new Produto();
        p1.setNome("pao de sal");
        p1.setId(1);
        listaProdutos.add(p1);
        p2 = new Produto();
        p2.setNome("pao de doce");
        p2.setId(2);
        listaProdutos.add(p2);


        Mockito.when(repositorio.save(newProduto)).thenReturn(createdProduto);
        Mockito.when(repositorio.findById(existingId)).thenReturn(Optional.of(new Produto()));
        Mockito.when(repositorio.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
        Mockito.when(repositorio.findAllByNomeContaining("biscoito")).thenReturn(new ArrayList<Produto>());
        Mockito.when(repositorio.findAllByNomeContaining(keyword)).thenReturn(listaProdutos);
        Mockito.when(repositorio.findAll()).thenReturn(listaProdutos);

    }

    @Test
    public void testCriarNovoProduto(){
        assertEquals(servico.criarNovoProduto(newProduto), createdProduto);
    }

    /*
    @Test
    public void testEditarProduto(){

    }
    */

    @Test
    public void testListarProdutos(){
        assertEquals(servico.listarProdutos(), listaProdutos);
    }
    @Test
    public void testBuscarProdutoPorChaves(){
        assertTrue(servico.buscarProdutoPorChave(keyword).size() > 0);
    }
    @Test
    public void testBuscarPorIdValid(){
        assertNotNull(servico.buscarPorId(existingId));
    }
    @Test
    public void testBuscarPorIdInvalid(){
        assertNull(servico.buscarPorId(nonExistingId));
    }

}
