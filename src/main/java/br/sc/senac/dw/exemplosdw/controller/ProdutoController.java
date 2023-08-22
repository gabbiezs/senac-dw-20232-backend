package br.sc.senac.dw.exemplosdw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exemplosdw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplosdw.model.entidade.Produto;
import br.sc.senac.dw.exemplosdw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
// produtoService anteriormente esse era o BO
	
	//METODO GET: UTILIZADO EM CONSULTAS
	//RETORNA TODOS
	@GetMapping(path = "/todos")
	public List<Produto> listarTodos() {
		
		return produtoService.listarTodos();
		
	}
	//METODO GET: UTILIZADO EM CONSULTAS
	//RETORNA UM PRODUTOP ESPECIFICO, DADO O SEU ID
	@GetMapping("/detalhe/{id}")
	public Produto pesquisarPorId (@PathVariable Integer id) {
		return produtoService.consultarPorId(id.longValue());
		
	}
	
	//METODO POST: INSERIR NOVOS REGISTROS
	//parametros são enviados no corpo da requisição HTTP
	//para isso utilizamos a anoção @RequestBody
	//retorna o produto salvo com o id preenchido
	@PostMapping
	public Produto salvar(@RequestBody Produto novoProduto) throws CampoInvalidoException{
		return produtoService.inserir(novoProduto);
	}
	
	//METODO POST: ATUALIZAR REGISTROS
	//parametros são enviados no corpo da requisição HTTP
	//para isso utilizamos a anoção @RequestBody
	//retorna um booleano indicando seo produto foi atualizado
	@PutMapping()
	public boolean atualizar(@RequestBody Produto produtoParaAtualizar) throws CampoInvalidoException{
		return produtoService.atualizar(produtoParaAtualizar) != null;
	}
	
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return produtoService.excluir(id);
	}
	
}
