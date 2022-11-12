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
        if(prod.getNome() == null || prod.getNome().length() == 0){
            return null;
        }
        return rep.save(prod);
    }

    @Override
    public Produto editarProduto(Produto prod) {
        return rep.save(prod);
    }

    @Override
    public List<Produto> listarProdutos() {
        return (List<Produto>)rep.findAll() ;
    }

    @Override
    public List<Produto> buscarProdutoPorChave(String prod) {
        return rep.findAllByNomeContaining(prod);
    }

    @Override
    public Produto buscarPorId(Integer id) {
        return rep.findById(id).orElse(null);
    }

    @Override
    public void removerProduto(Integer id){
        rep.deleteById(id);
    }
}
