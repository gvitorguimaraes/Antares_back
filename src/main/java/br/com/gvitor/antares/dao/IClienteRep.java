package br.com.gvitor.antares.dao;

import br.com.gvitor.antares.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRep extends CrudRepository<Cliente, Integer> {
    public List<Cliente> findAllByNomeContaining(String key);
}
