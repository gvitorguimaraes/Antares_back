package br.com.gvitor.antares.service;

import br.com.gvitor.antares.dao.IProdutoRep;
import br.com.gvitor.antares.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements IProdutoService{

    @Autowired
    private IProdutoRep rep;
    @Override
    public Produto criarNovoProduto(Produto prod) {
        return rep.save(prod);
    }

    @Override
    public Produto editarProduto(Produto prod) {
        return null;
    }

    @Override
    public List<Produto> listarProdutos() {
        return null;
    }

    @Override
    public List<Produto> buscarProdutoPorChave(String prod) {
        return null;
    }

    @Override
    public Produto buscarPorId(Integer id) {
        return null;
    }
}
