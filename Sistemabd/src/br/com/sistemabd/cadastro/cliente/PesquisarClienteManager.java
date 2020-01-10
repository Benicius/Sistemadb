package br.com.sistemabd.cadastro.cliente;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.Mensagem;
import util.Resultado;
import util.RetornoNegocio;

@ManagedBean
@ViewScoped
public class PesquisarClienteManager implements Serializable
{
	private Cliente cliente;
	private ClienteNegocio negocio = new ClienteNegocio();
	private LazyClienteModel model = new LazyClienteModel();
	
	public void excluir()
	{
		RetornoNegocio retorno = negocio.excluir(cliente);
		
		if(retorno.getResultado() == Resultado.ACEITO)
		{
			Mensagem.addMensagemInfo(retorno.getMensagem());
		}
		else
		{
			Mensagem.addMensagemError(retorno.getMensagem());
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteNegocio getNegocio() {
		return negocio;
	}

	public void setNegocio(ClienteNegocio negocio) {
		this.negocio = negocio;
	}

	public LazyClienteModel getModel() {
		return model;
	}

	public void setModel(LazyClienteModel model) {
		this.model = model;
	}
	
}
