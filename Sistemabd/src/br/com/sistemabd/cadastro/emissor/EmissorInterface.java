package br.com.sistemabd.cadastro.emissor;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;


public interface EmissorInterface 
{
	public void salvar(Emissor emissor);
	public Emissor obter(Long chave);
	
	public List<Emissor> pesquisarEmissor(
			String nome, 
			String nomeFantasia, 
			String cnpj,
			int first,
			int pageSize,
			SortOrder order,
			String orderfield,
			Map<String, Object> filters);
	
	public Integer quantidadeLinhas(
			String nome, 
			String nomeFantasia, 
			String cnpj,
			Map<String, Object> filters);
}