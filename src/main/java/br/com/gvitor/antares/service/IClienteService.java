package br.com.gvitor.antares.service;

import br.com.gvitor.antares.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {

    public Cliente cadastraCliente(Cliente cliente);

    public Cliente editarCliente(Cliente cliente);

    public List<Cliente> listarClientes();
    public Cliente consultarCliente(Integer id);

    public List<Cliente> consultarClientePalavraChave(String chave);
    public void removerCliente(Integer id);
}
