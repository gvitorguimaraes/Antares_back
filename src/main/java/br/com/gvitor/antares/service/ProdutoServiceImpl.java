package br.com.gvitor.antares.service;

import br.com.gvitor.antares.dao.IProdutoDao;
import br.com.gvitor.antares.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService{

    @Autowired
    private IProdutoDao dao;
    @Override
    public Produto criarNovoProduto(Produto prod) {
        return dao.save(prod);
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
