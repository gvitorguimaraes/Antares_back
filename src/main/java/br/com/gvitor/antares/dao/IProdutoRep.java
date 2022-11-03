package br.com.gvitor.antares.dao;

import br.com.gvitor.antares.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRep extends CrudRepository<Produto, Integer> {

}
