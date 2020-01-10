package br.com.sistemabd.produto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import util.Mensagem;
import util.Resultado;
import util.RetornoNegocio;

@ManagedBean
@ViewScoped
public class CadastrarProdutoManager implements Serializable
{
	private ProdutoNegocio negocio = new ProdutoNegocio();
	private boolean visualizar = false;
	
	public void novo()
	{
		negocio = new ProdutoNegocio();
		visualizar = false;
	}

	public void carregar(Long chave)
	{
		novo();
		visualizar = true;
	}
	
	public void salvar()
	{
		RetornoNegocio retorno = negocio.salvar();
		
		if(retorno.getResultado() == Resultado.ACEITO)
		{
			Mensagem.addMensagemInfo(retorno.getMensagem());
			RequestContext.getCurrentInstance().update("formCadasrtar");
			RequestContext.getCurrentInstance().execute("PF('dlgCadastrar').hide(");
		}
		else
		{
			Mensagem.addMensagemError(retorno.getMensagem());
		}
	}
	
	public ProdutoNegocio getNegocio() {
		return negocio;
	}
	public void setNegocio(ProdutoNegocio negocio) {
		this.negocio = negocio;
	}
	public boolean isVisualizar() {
		return visualizar;
	}
	public void setVisualizar(boolean visualizar) {
		this.visualizar = visualizar;
	}
}
