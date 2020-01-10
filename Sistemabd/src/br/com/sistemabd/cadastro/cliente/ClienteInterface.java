package br.com.sistemabd.cadastro.cliente;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

public interface ClienteInterface 
{
	public void salvar(Cliente cliente);
	public Cliente obter(Long chave);
	
	public List<Cliente> pesquisar(
			String nome,
			int first,
			int pagesize,
			SortOrder order,
			String orderField,
			Map<String, Object> filters);
	
	public Integer quantidadeLinhas(
			String nome,
			Map<String, Object> filters);
}
