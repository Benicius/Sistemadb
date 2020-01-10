package br.com.sistemabd.cadastro.emissor;

import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;

public class EmissorDAO implements EmissorInterface
{
	private Session session;
	
	public EmissorDAO(Session session)
	{
		this.session = session;
	}

	@Override
	public void salvar(Emissor emissor) 
	{
		session.beginTransaction();
		
		session.saveOrUpdate(emissor);
		
		session.getTransaction().commit();
		
		session.close();
	}

	@Override
	public Emissor obter(Long chave) 
	{
		Criteria criteria = session.createCriteria(Emissor.class);
		criteria.add(Restrictions.eq("chave", chave));
		
		return (Emissor)criteria.uniqueResult();
	}

	@Override
	public List<Emissor> pesquisarEmissor(
			String nome, 
			String nomeFantasia, 
			String cnpj, 
			int first, 
			int pageSize,
			SortOrder order, 
			String orderfield, 
			Map<String, Object> filters) 
	{
		Criteria criteria = session.createCriteria(Emissor.class);
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);
		
		criteria.add(Restrictions.like("nome", nome+"%"));
		criteria.add(Restrictions.like("nomeFantasia", nomeFantasia+"%"));
		criteria.add(Restrictions.like("cnpj", cnpj+"%"));
		
		criteria.add(Restrictions.eq("excluido", false));
		
		if(orderfield != null)
		{
			criteria.addOrder(order == org.primefaces.model.SortOrder.ASCENDING ? 
					Order.asc(orderfield) : Order.desc(orderfield));
		}
		
		if(filters != null)
		{
			for(java.util.Map.Entry<String, Object> f: filters.entrySet())
			{
				criteria.add(Restrictions.ilike(f.getKey(), f.getValue()+"%"));
			}
		}
		return criteria.list();
	}

	@Override
	public Integer quantidadeLinhas(
			String nome, 
			String nomeFantasia, 
			String cnpj, 
			Map<String, Object> filters) 
	{
		Criteria criteria = session.createCriteria(Emissor.class).setProjection(Projections.count("chave"));
		
		criteria.add(Restrictions.like("nome", nome+"%"));
		criteria.add(Restrictions.like("nomeFantasia", nomeFantasia+"%"));
		criteria.add(Restrictions.like("cnpj", cnpj+"%"));
		
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
