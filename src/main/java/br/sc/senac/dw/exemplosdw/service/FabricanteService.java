package br.sc.senac.dw.exemplosdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.exemplosdw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplosdw.model.entidade.Fabricante;
import br.sc.senac.dw.exemplosdw.model.repository.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
    private FabricanteRepository fabricanteRepository;

	@Transactional
	public List<Fabricante> listarTodos() {
		return fabricanteRepository.findAll();
	}

	public Fabricante inserir(Fabricante novoFabricante) throws CampoInvalidoException {
		validarCamposObrigatorios(novoFabricante);
		return fabricanteRepository.save(novoFabricante);
	}
	
	private void validarCamposObrigatorios(Fabricante fabricante) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(fabricante.getNome(), "nome");
		mensagemValidacao += validarCampoString(fabricante.getCnpj(), "cnpj");
		mensagemValidacao += validarCampoString(fabricante.getCidade(), "cidade");
		mensagemValidacao += validarCampoString(fabricante.getCep(), "cep");
		mensagemValidacao += validarCampoString(fabricante.getUf(), "uf");

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

}
