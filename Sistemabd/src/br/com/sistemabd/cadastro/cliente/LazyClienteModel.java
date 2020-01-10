package br.com.sistemabd.cadastro.cliente; 

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import bancodados.FabricaDAO;

public class LazyClienteModel extends LazyDataModel<Cliente>
{
	private String nome;
	
	@Override
	public List<Cliente> load(
			int first, 
			int pageSize, 
			String sortField, 
			SortOrder sortOrder,
			Map<String, Object> filters) 
	{
		ClienteInterface cDAO = FabricaDAO.criarClienteDAO();
		setRowCount(cDAO.quantidadeLinhas(nome, filters));
		return cDAO.pesquisar(nome, first, pageSize, sortOrder, sortField, filters);
		
	}
	
	@Override
	public Cliente getRowData(String rowKey)
	{
		ClienteInterface cDAO = FabricaDAO.criarClienteDAO();
		return cDAO.obter(Long.parseLong(rowKey));
	}
	
	@Override
	public Object getRowKey(Cliente object) 
	{
		return object.getChave().toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
