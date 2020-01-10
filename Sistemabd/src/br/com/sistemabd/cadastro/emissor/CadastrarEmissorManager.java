package br.com.sistemabd.cadastro.emissor;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import bancodados.FabricaDAO;
import util.Mensagem;
import util.Resultado;
import util.RetornoNegocio;

@ManagedBean
@ViewScoped
public class CadastrarEmissorManager implements Serializable
{
	private EmissorNegocio negocio = new EmissorNegocio();
	private boolean visualizar = false;
	
	public void novo()
	{
		negocio = new EmissorNegocio();
		visualizar = false;
		
	}
	
	public void carregar(Long chave)
	{
		novo();
		visualizar = true;
		
		EmissorInterface eDAO = FabricaDAO.criarEmissorDAO();
		negocio.setEmissor(eDAO.obter(chave));
	}
	
	public void salvar()
	{
		RetornoNegocio retorno = negocio.salvar();
		
		if(retorno.getResultado() == Resultado.ACEITO)
		{
			Mensagem.addMensagemInfo(retorno.getMensagem());
			RequestContext.getCurrentInstance().update("form");
			RequestContext.getCurrentInstance().execute("PF('dlg_cadastrar').hide()");
		}
		else
		{
			Mensagem.addMensagemError(retorno.getMensagem());
		}
	}

	public EmissorNegocio getNegocio() {
		return negocio;
	}

	public void setNegocio(EmissorNegocio negocio) {
		this.negocio = negocio;
	}

	public boolean isVisualizar() {
		return visualizar;
	}

	public void setVisualizar(boolean visualizar) {
		this.visualizar = visualizar;
	}
}