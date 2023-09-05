package br.sc.senac.dw.exemplosdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.exemplosdw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplosdw.model.entidade.Produto;
import br.sc.senac.dw.exemplosdw.model.repository.ProdutoRepository;
import br.sc.senac.dw.exemplosdw.model.seletor.ProdutoSeletor;
import br.sc.senac.dw.exemplosdw.model.specification.ProdutoSpecifications;

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
		validarCamposObrigatorios(novoProduto);
		return produtoRepository.save(novoProduto);
	}
	
	public Produto atualizar(Produto produtoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(produtoParaAtualizar);
		return produtoRepository.save(produtoParaAtualizar);
	}
	
	public boolean excluir(Integer id) {
		produtoRepository.deleteById(id.longValue());
		return true;
	}

	public List<Produto> listarComSeletor(ProdutoSeletor seletor) {
		Specification<Produto> specification = ProdutoSpecifications.comFiltros(seletor);
		return produtoRepository.findAll(specification);
	}
	
	private void validarCamposObrigatorios(Produto produto) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(produto.getNome(), "nome");
		mensagemValidacao += validarCampoDouble(produto.getValor(), "valor");
		mensagemValidacao += validarCampoDouble(produto.getPeso(), "peso");

		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if(valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
}