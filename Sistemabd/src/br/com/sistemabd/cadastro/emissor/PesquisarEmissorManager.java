package br.com.sistemabd.cadastro.emissor;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.Mensagem;
import util.Resultado;
import util.RetornoNegocio;

@ManagedBean
@ViewScoped
public class PesquisarEmissorManager implements Serializable
{
	private Emissor emissor;
	private EmissorNegocio negocio = new EmissorNegocio();
	private LazyEmissorModel model = new LazyEmissorModel();
	
	public void excluir()
	{
		RetornoNegocio retorno = negocio.excluir(emissor);
		
		if(retorno.getResultado() == Resultado.ACEITO)
		{
			Mensagem.addMensagemInfo(retorno.getMensagem());
		}
		else
		{
			Mensagem.addMensagemError(retorno.getMensagem());
		}
	}

	public Emissor getEmissor() {
		return emissor;
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}

	public EmissorNegocio getNegocio() {
		return negocio;
	}

	public void setNegocio(EmissorNegocio negocio) {
		this.negocio = negocio;
	}

	public LazyEmissorModel getModel() {
		return model;
	}

	public void setModel(LazyEmissorModel model) {
		this.model = model;
	}
}
