package br.sc.senac.dw.exemplosdw.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.dw.exemplosdw.model.entidade.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
