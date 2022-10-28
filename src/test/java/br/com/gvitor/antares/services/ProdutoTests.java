package br.com.gvitor.antares.services;

import br.com.gvitor.antares.model.Produto;
import br.com.gvitor.antares.service.IProdutoService;
import br.com.gvitor.antares.service.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProdutoTests {
    @Autowired
    private static ProdutoServiceImpl service;
    private static Integer idFound = 1;
    private static Integer idNotFound = 100;
    private static Produto newProduct;
    private static Produto createdProduct;

    @BeforeAll
    public static void setup(){
        System.out.println("Configurando o ambiente...");
        newProduct = new Produto();
        newProduct.setNome("Bolacha");

        createdProduct = new Produto();
        createdProduct.setNome("Bolacha");
        createdProduct.setId(1);

        service = Mockito.mock(ProdutoServiceImpl.class);
        Mockito.when(service.criarNovoProduto(newProduct)).thenReturn(new Produto());
        Mockito.when(service.buscarPorId(idFound)).thenReturn(createdProduct);
        Mockito.when(service.buscarPorId(idNotFound)).thenReturn(null);
        Mockito.when(service.buscarProdutoPorChave("b")).thenReturn(new ArrayList<Produto>());
        Mockito.when(service.listarProdutos()).thenReturn(new ArrayList<Produto>());
        Mockito.when(service.editarProduto(newProduct)).thenReturn(createdProduct);
    }

    @Test
    public void teste(){
        assertNotNull(service.criarNovoProduto(newProduct));
    }
}
