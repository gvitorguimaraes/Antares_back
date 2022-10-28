package br.com.gvitor.antares.dao;

import br.com.gvitor.antares.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface IProdutoDao extends CrudRepository<Produto, Integer> {

}
