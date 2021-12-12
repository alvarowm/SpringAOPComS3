package br.alvaro.ativo.bo;

import br.alvaro.ativo.model.AtivoModel;

public class AtivoBO {
	
	private AtivoModel ativo;
	private Float TAXA_CORRETAGEM = 0.003f;
	
	public void setAtivo(AtivoModel ativo) {
		this.ativo = ativo;
	}

	public AtivoModel calcularTaxa() {
		ativo.setTaxa(ativo.getPrecoDoAtivo() * TAXA_CORRETAGEM);
		return ativo;
	}

}
