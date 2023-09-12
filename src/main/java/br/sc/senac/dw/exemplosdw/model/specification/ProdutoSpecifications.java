package br.sc.senac.dw.exemplosdw.model.specification;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.exemplosdw.model.entidade.Produto;
import br.sc.senac.dw.exemplosdw.model.seletor.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoSpecifications {

    public static Specification<Produto> comFiltros(ProdutoSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" 
                		+ seletor.getNome().toLowerCase() + "%"));
            }
            
            if (seletor.getFabricante() != null && !seletor.getFabricante().isEmpty()) {
                predicates.add(cb.like(root.join("fabricanteDoProduto").get("nome"), 
                						"%" + seletor.getFabricante() + "%"));
            }
            
            if(seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
            	//WHERE peso BETWEEN min AND max
            	predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(), 
            			seletor.getPesoMaximo()));
            } else if(seletor.getPesoMinimo() != null) {
            	//WHERE peso >= min
            	predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));
            } else if(seletor.getPesoMaximo() != null) {
            	//WHERE peso <= max
            	predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
            }
            
            if(seletor.getValorMinimo() != null && seletor.getValorMaximo() != null) {
            	//WHERE VALOR BETWEEN MIN AND MAX
            	predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(), 
            			seletor.getValorMaximo()));
            } else if(seletor.getValorMinimo() != null) {
            	//WHERE VALOR >= min
            	predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
            } else if(seletor.getValorMaximo() != null) {
            	//WHERE VALOR <= max
            	predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
            }
            
            if(seletor.getCnpj() != null && !seletor.getCnpj().isEmpty()) {
            	predicates.add(cb.equal(root.join("fabricanteDoProduto").get("cnpj"), seletor.getCnpj()));
            }
            
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
