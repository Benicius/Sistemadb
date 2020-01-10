package br.com.sistemabd.cadastro.cliente;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;

import bancodados.FabricaDAO;
import br.com.sistemabd.cadastro.veiculo.Veiculo;
import util.Mensagem;
import util.Resultado;
import util.RetornoNegocio;

@ManagedBean
@ViewScoped
public class CadastrarClienteManager implements Serializable
{
	private ClienteNegocio negocio = new ClienteNegocio();
	private boolean visualizar = false;
	private boolean fisica = false;
	private boolean juridica = false;
	
	public void novo()
	{
		negocio = new ClienteNegocio();
		visualizar = false;
		
		negocio.getCliente().getVeiculos().add(new Veiculo());
	}
	
	public void carregar(Long chave)
	{
		novo();
		visualizar = true;
		
		ClienteInterface cDAO = FabricaDAO.criarClienteDAO();
		negocio.setCliente(cDAO.obter(chave));
		
		if(negocio.getCliente().getTipo().equals("fisica"))
		{
			fisica = true;
		}
		else
		{
			juridica = true;
		}
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
	
	public void selecionarPessoa(ValueChangeEvent evento)
	{
		if(evento.getNewValue().toString().equals("fisica"))
		{
			fisica = true;
			juridica = false;
		}
		else
		{
			juridica = true;
			fisica = false;
		}
	}

	public ClienteNegocio getNegocio() {
		return negocio;
	}

	public void setNegocio(ClienteNegocio negocio) {
		this.negocio = negocio;
	}

	public boolean isVisualizar() {
		return visualizar;
	}

	public void setVisualizar(boolean visualizar) {
		this.visualizar = visualizar;
	}

	public boolean isFisica() {
		return fisica;
	}

	public void setFisica(boolean fisica) {
		this.fisica = fisica;
	}

	public boolean isJuridica() {
		return juridica;
	}

	public void setJuridica(boolean juridica) {
		this.juridica = juridica;
	}
}
