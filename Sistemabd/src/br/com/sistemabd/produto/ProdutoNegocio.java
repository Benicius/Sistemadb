package br.com.sistemabd.produto;

import java.io.Serializable;

import util.Resultado;
import util.RetornoNegocio;

public class ProdutoNegocio implements Serializable
{
	private Produto produto = new Produto();
	
	public RetornoNegocio salvar()
	{
		return new RetornoNegocio(Resultado.ACEITO, "O produto foi salvo com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
