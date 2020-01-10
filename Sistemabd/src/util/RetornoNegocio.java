package util;

public class RetornoNegocio 
{
	private Resultado resultado;
	private String mensagem;
	private Object objeto;
	
	public RetornoNegocio(Resultado resultado, String mensagem)
	{
		super();
		this.resultado = resultado;
		this.mensagem = mensagem;
	}
	
	public RetornoNegocio(Resultado resultado, String mensagem, Object objeto)
	{
		super();
		this.resultado = resultado;
		this.mensagem = mensagem;
		this.objeto = objeto;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
}
