package br.sc.senac.dw.exemplosdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}