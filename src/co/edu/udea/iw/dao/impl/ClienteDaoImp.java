package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class ClienteDaoImp implements ClienteDao {

	@Override
	public List<Cliente> obtener() throws MyException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session= null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Cliente.class);
			clientes =criteria.list();
		} catch (Exception e) {
			throw new MyException(e);
		}finally{
			if (session!=null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
		
		return clientes;
	}

	@Override
	public Cliente obtener(String cedula) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Cliente Cliente) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.save(Cliente);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		}finally{
			if (session!=null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
	}

	@Override
	public void actualizar(Cliente Cliente) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Cliente Cliente) throws MyException {
		// TODO Auto-generated method stub

	}

}
