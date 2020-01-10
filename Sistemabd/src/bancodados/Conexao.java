package bancodados;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.sistemabd.cadastro.cliente.Cliente;
import br.com.sistemabd.cadastro.emissor.Emissor;
import br.com.sistemabd.cadastro.endereco.Endereco;
import br.com.sistemabd.cadastro.veiculo.Veiculo;

public class Conexao
{
	private static SessionFactory session;
	
	public static SessionFactory abrirConexao()
	{
		Configuration conf = new Configuration();
		
		conf.addAnnotatedClass(Emissor.class);
		conf.addAnnotatedClass(Endereco.class);
		conf.addAnnotatedClass(Cliente.class);
		conf.addAnnotatedClass(Veiculo.class);
		
		conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		
		conf.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		conf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sistemabd_homologacao?autoReconnect=true");
		conf.setProperty("hibernate.connection.username", "root");
		conf.setProperty("hibernate.connection.password", "root");
		
		conf.setProperty("hibernate.hbm2ddl.auto", "update");
		
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		
		session = conf.buildSessionFactory(sr);
		
		return session;
	}
}
