package br.com.gvitor.antares.service;

import br.com.gvitor.antares.dao.IItemDocRep;
import br.com.gvitor.antares.model.ItemDocumento;
import org.springframework.stereotype.Service;

@Service
public class ItemDocServiceImpl implements IItemDocService{

    private IItemDocRep repo;
    @Override
    public ItemDocumento novoItem(ItemDocumento item) {
        return repo.save(item);
    }
    @Override
    public ItemDocumento editarItem(ItemDocumento item) {
        return repo.save(item);
    }
    @Override
    public void excluirItem(Integer id) {
        repo.deleteById(id);
    }
}
