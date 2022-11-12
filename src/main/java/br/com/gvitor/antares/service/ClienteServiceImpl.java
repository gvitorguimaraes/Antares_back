package br.com.gvitor.antares.service;

import br.com.gvitor.antares.dao.IClienteRep;
import br.com.gvitor.antares.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRep repo;

    @Override
    public Cliente cadastraCliente(Cliente cliente) {
        if(cliente.getNome() == null || cliente.getNome().length() == 0){
            return null;
        } else if (cliente.getCpf_cnpj().length() == 0 || cliente.getCpf_cnpj() == null) {
            return null;
        }
        return repo.save(cliente);
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>)repo.findAll() ;
    }

    @Override
    public Cliente consultarCliente(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> consultarClientePalavraChave(String chave){
        return repo.findAllByNomeContaining(chave);
    }

    @Override
    public void removerCliente(Integer id) {
        repo.deleteById(id);
    }
}
