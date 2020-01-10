package br.com.sistemabd.cadastro.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.sistemabd.cadastro.endereco.Endereco;
import br.com.sistemabd.cadastro.veiculo.Veiculo;


@Entity
@Table(name="cad03_cliente")
public class Cliente implements Serializable
{
	@Id @GeneratedValue
	private Long chave;
	
	private String nome;
	
	private String rg;
	private String cpf;
	private String cnpj;
	private String telefone;
	private String email;
	private String tipo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();
	
	private boolean excluido = false;
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getChave() {
		return chave;
	}
	public void setChave(Long chave) {
		this.chave = chave;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isExcluido() {
		return excluido;
	}
	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	
}
