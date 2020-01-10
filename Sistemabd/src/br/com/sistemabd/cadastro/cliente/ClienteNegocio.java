package br.com.sistemabd.cadastro.cliente;

import java.io.Serializable;

import bancodados.FabricaDAO;
import br.com.sistemabd.cadastro.veiculo.Veiculo;
import util.Resultado;
import util.RetornoNegocio;

public class ClienteNegocio implements Serializable
{
	private Cliente cliente = new Cliente();
	
	public RetornoNegocio salvar()
	{
		ClienteInterface cDAO = FabricaDAO.criarClienteDAO();
		cDAO.salvar(cliente);
		
		return new RetornoNegocio(Resultado.ACEITO, "Cliente salvo com sucesso!");
	}
	
	public RetornoNegocio excluir(Cliente cliente)
	{
		ClienteInterface cDAO = FabricaDAO.criarClienteDAO();
		cliente.setExcluido(true);
		cDAO.salvar(cliente);
		
		return new RetornoNegocio(Resultado.ACEITO, "Cliente excluído com sucesso!");
	}
	
	public void adicionarVeiculo()
	{
		cliente.getVeiculos().add(new Veiculo());
	}
	
	public int getQuantidadeVeiculo()
	{
		return cliente.getVeiculos().size();
	}
	
	public void excluirVeiculo(int index)
	{
		cliente.getVeiculos().remove(index);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
