package br.com.sistemabd.cadastro.emissor;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import bancodados.FabricaDAO;

public class LazyEmissorModel extends LazyDataModel<Emissor>
{
	private String nome;
	private String nomeFantasia;
	private String cnpj;
	
	@Override
	public List<Emissor> load(
			int first, 
			int pageSize, 
			String sortField, 
			SortOrder sortOrder,
			Map<String, Object> filters) 
	{
		EmissorInterface eDAO = FabricaDAO.criarEmissorDAO();
		setRowCount(eDAO.quantidadeLinhas(nome, nomeFantasia, cnpj, filters));
		
		return eDAO.pesquisarEmissor(nome, nomeFantasia, cnpj, first, pageSize, sortOrder, sortField, filters);
	}
	
	@Override
	public Emissor getRowData(String rowKey) 
	{
		EmissorInterface eDAO = FabricaDAO.criarEmissorDAO();
		
		return eDAO.obter(Long.parseLong(rowKey));
	}
	
	@Override
	public Object getRowKey(Emissor object) 
	{
		return object.getChave().toString();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}	
