package br.com.gvitor.antares.dao;

import br.com.gvitor.antares.model.Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoRep extends CrudRepository<Documento, Integer> {
}
