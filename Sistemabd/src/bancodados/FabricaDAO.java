package bancodados;

import br.com.sistemabd.cadastro.cliente.ClienteDAO;
import br.com.sistemabd.cadastro.cliente.ClienteInterface;
import br.com.sistemabd.cadastro.emissor.EmissorDAO;
import br.com.sistemabd.cadastro.emissor.EmissorInterface;

public class FabricaDAO 
{
	public static EmissorInterface criarEmissorDAO()
	{
		return new EmissorDAO(Conexao.abrirConexao().openSession());
	}
	public static ClienteInterface criarClienteDAO()
	{
		return new ClienteDAO(Conexao.abrirConexao().openSession());
	}
}
