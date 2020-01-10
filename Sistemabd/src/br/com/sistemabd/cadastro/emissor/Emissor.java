package br.com.sistemabd.cadastro.emissor;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.sistemabd.cadastro.endereco.Endereco;

@Entity
@Table(name="cad01_emissor")
public class Emissor implements Serializable
{
	@Id @GeneratedValue
	private Long chave;
	
	private String nome;
	private String nomeFantasia;
	private String cnpj;
	private String telefone;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();
	
	private boolean excluido = false;
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
