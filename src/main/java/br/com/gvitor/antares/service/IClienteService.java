package br.com.gvitor.antares.service;

import br.com.gvitor.antares.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface IClienteService {

    public Cliente cadastraCliente(Cliente cliente);

    public Cliente editarCliente(Cliente cliente);

    public Cliente consultarCliente(Integer id);

    public void removerCliente(Integer id);
}
