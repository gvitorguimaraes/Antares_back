package br.com.gvitor.antares.service;

import br.com.gvitor.antares.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProdutoService {
    public Produto criarNovoProduto(Produto prod);
    public Produto editarProduto(Produto prod);
    public List<Produto> listarProdutos();
    public List<Produto> buscarProdutoPorChave(String prod);
    public Produto buscarPorId(Integer id);

    public void removerProduto(Integer id);
}
