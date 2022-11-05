package br.com.gvitor.antares.services;

import br.com.gvitor.antares.dao.IClienteRep;
import br.com.gvitor.antares.model.Cliente;
import br.com.gvitor.antares.service.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteTests {

    @InjectMocks
    private ClienteServiceImpl servico;

    @Mock
    private IClienteRep repositorio;
    private Integer existingId = 1;
    private Integer nonExistingId = 100;
    private String keyword = "Gabriel";
    private Cliente novoCliente;
    private Cliente createdCliente;
    private ArrayList<Cliente> listaClientes;

    @BeforeEach
    public void setup() throws Exception {
        novoCliente = new Cliente();
        novoCliente.setNome("Gabriel");
        novoCliente.setCpf_cnpj("78349746025");

        createdCliente = new Cliente();
        createdCliente.setId(1);
        createdCliente.setNome("Gabriel");
        createdCliente.setCpf_cnpj("78349746025");

        listaClientes = new ArrayList<Cliente>();
        Cliente c1, c2;
        c1 = new Cliente();
        c1.setId(2);
        c1.setNome("Gabriel Silva");
        c1.setCpf_cnpj("10211833002");
        listaClientes.add(c1);
        c2 = new Cliente();
        c2.setId(3);
        c2.setNome("Gabriel Santos");
        c2.setCpf_cnpj("03250872024");
        listaClientes.add(c2);

        Mockito.when(repositorio.save(novoCliente)).thenReturn(createdCliente);
        Mockito.when(repositorio.findAll()).thenReturn(listaClientes);
        Mockito.when(repositorio.findAllByNomeContaining(keyword)).thenReturn(listaClientes);
        Mockito.when(repositorio.findById(existingId)).thenReturn(Optional.of(new Cliente()));
        Mockito.when(repositorio.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));


    }

    @Test
    public void testCadastrarCliente() {
        assertEquals(servico.cadastraCliente(novoCliente), createdCliente);
    }

    @Test
    public void testListarClientes() {
        assertEquals(servico.listarClientes(), listaClientes);
    }

    @Test
    public void testBuscarClientePalavraChave() {
        assertTrue(servico.consultarClientePalavraChave(keyword).size() > 0);
    }

    @Test
    public void testBuscarClientePorIdFind(){
        assertNotNull(servico.consultarCliente(existingId));
    }

    @Test
    public void testBuscarClientePorIdNotFind(){
        assertNull(servico.consultarCliente(nonExistingId));
    }

    /*
    * @Test
    * public void testEditarCliente(){
    * }
    *
    * @Test
    * public void testRemoverCliente(){
    * }
    * */
}