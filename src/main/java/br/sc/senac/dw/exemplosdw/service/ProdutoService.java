package br.sc.senac.dw.exemplosdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.exemplosdw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplosdw.model.entidade.Produto;
import br.sc.senac.dw.exemplosdw.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
    private ProdutoRepository produtoRepository;
	//Repository serve como o antigo DAO do semestre passado

	@Transactional
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Produto consultarPorId(Long id) {
		return produtoRepository.findById(id.longValue()).get();
	}

	public Produto inserir(Produto novoProduto) throws CampoInvalidoException {
		return produtoRepository.save(novoProduto);
	}
	
	public Produto atualizar(Produto produtoParaAtualizar) throws CampoInvalidoException {
		return produtoRepository.save(produtoParaAtualizar);
	}
	
	public boolean excluir(Integer id) {
		produtoRepository.deleteById(id.longValue());
		return true;
	}
}