package br.sc.senac.dw.exemplosdw.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exemplosdw.model.entidade.Produto;
import br.sc.senac.dw.exemplosdw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
// produtoService anteriormente esse era o BO
	
	@GetMapping
	public List<Produto> listarTodos() {
		
		return produtoService.listarTodos();
		
	}
}
