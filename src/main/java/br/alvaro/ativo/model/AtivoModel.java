package br.alvaro.ativo.model;

public class AtivoModel {

	private String nomeDoAtivo;
	private String codigoDoAtivo;
	private Float precoDoAtivo;
	private Float taxa;

	public String getNomeDoAtivo() {
		return nomeDoAtivo;
	}

	public void setNomeDoAtivo(String nomeDoAtivo) {
		this.nomeDoAtivo = nomeDoAtivo;
	}

	public String getCodigoDoAtivo() {
		return codigoDoAtivo;
	}

	public void setCodigoDoAtivo(String codigoDoAtivo) {
		this.codigoDoAtivo = codigoDoAtivo;
	}

	public Float getPrecoDoAtivo() {
		return precoDoAtivo;
	}

	public void setPrecoDoAtivo(Float precoDoAtivo) {
		this.precoDoAtivo = precoDoAtivo;
	}

	public Float getTaxa() {
		return taxa;
	}

	public void setTaxa(Float taxa) {
		this.taxa = taxa;
	}

}
