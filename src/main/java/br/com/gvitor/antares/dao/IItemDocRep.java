package br.com.gvitor.antares.dao;

import br.com.gvitor.antares.model.ItemDocumento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemDocRep extends CrudRepository<ItemDocumento, Integer> {
}
