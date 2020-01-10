package br.com.sistemabd.cadastro.emissor;

import java.io.Serializable;

import bancodados.FabricaDAO;
import util.Resultado;
import util.RetornoNegocio;

public class EmissorNegocio implements Serializable
{
	private Emissor emissor = new Emissor();
	
	public RetornoNegocio salvar()
	{
		EmissorInterface eDAO = FabricaDAO.criarEmissorDAO();
		eDAO.salvar(emissor);
		return new RetornoNegocio(Resultado.ACEITO, "Emissor cadastrado com sucesso!");
	}
	
	public RetornoNegocio excluir(Emissor emissor)
	{
		EmissorInterface eDAO = FabricaDAO.criarEmissorDAO();
		emissor.setExcluido(true);
		eDAO.salvar(emissor);
		
		return new RetornoNegocio(Resultado.ACEITO, "Emissor excluído com sucesso!");
	}

	public Emissor getEmissor() {
		return emissor;
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}
}
