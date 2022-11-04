package br.com.gvitor.antares.service;

import br.com.gvitor.antares.model.ItemDocumento;
import org.springframework.stereotype.Service;

@Service
public interface IItemDocService {
    public ItemDocumento novoItem(ItemDocumento item);
    public ItemDocumento editarItem(ItemDocumento item);
    public void excluirItem();

}
