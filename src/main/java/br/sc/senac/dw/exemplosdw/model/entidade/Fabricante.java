package br.sc.senac.dw.exemplosdw.model.entidade;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		private String cnpj;
		private String cidade;
		private String cep;
		private String uf;
		
		@JsonBackReference
	    @OneToMany(mappedBy = "fabricanteDoProduto")
	    private List<Produto> produtos;

		public Fabricante() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Fabricante(Integer id, String nome, String cnpj, String cidade, String cep, String uf,
				List<Produto> produtos) {
			super();
			this.id = id;
			this.nome = nome;
			this.cnpj = cnpj;
			this.cidade = cidade;
			this.cep = cep;
			this.uf = uf;
			this.produtos = produtos;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public List<Produto> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}

}
