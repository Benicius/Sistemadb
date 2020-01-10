package br.com.sistemabd.cadastro.cliente;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;


public class ClienteDAO implements ClienteInterface
{
	private Session session;
	
	public ClienteDAO(Session session)
	{
		this.session = session;
	}

	@Override
	public void salvar(Cliente cliente) 
	{
		session.beginTransaction();
		
		session.saveOrUpdate(cliente);
		
		session.getTransaction().commit();
		
		session.close();
		
	}

	@Override
	public Cliente obter(Long chave) 
	{
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("chave", chave));
		
		return (Cliente)criteria.uniqueResult();
	}

	@Override
	public List<Cliente> pesquisar(
			String nome, 
			int first, 
			int pagesize, 
			SortOrder order, 
			String orderField,
			Map<String, Object> filters) 
	{
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.setFirstResult(first);
		criteria.setMaxResults(pagesize);
		
		criteria.add(Restrictions.like("nome", nome+"%"));
		criteria.add(Restrictions.eq("excluido", false));
		
		if(orderField != null)
		{
			criteria.addOrder(order == org.primefaces.model.SortOrder.ASCENDING ?
					Order.asc(orderField) : Order.desc(orderField));
			
		}
		if(filters != null)
		{
			for(java.util.Map.Entry<String, Object> f : filters.entrySet())
			{
				criteria.add(Restrictions.ilike(f.getKey(), f.getValue()+"%"));
			}
		}
		return criteria.list();
	}

	@Override
	public Integer quantidadeLinhas(
			String nome, 
			Map<String, Object> filters) 
	{
		Criteria criteria = session.createCriteria(Cliente.class).setProjection(Projections.count("chave"));
		
		criteria.add(Restrictions.like("nome", nome+"%"));
		criteria.add(Restrictions.eq("excluido", false));
		
		if(filters != null)
		{
			for(java.util.Map.Entry<String, Object> f: filters.entrySet())
			{
				criteria.add(Restrictions.ilike(f.getKey(), f.getValue()+"%"));
			}
		}
		
		Object result = criteria.uniqueResult();
		
		if(result != null)
			return Integer.parseInt(result.toString());
		
		return 0;
	}
	
	
}
