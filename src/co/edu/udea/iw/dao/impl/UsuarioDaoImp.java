package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDaoImp implements UsuarioDao {

	@Override
	public List<Usuario> obtener() throws MyException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session= null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			usuarios = criteria.list();
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
		
		return usuarios;
	}

	@Override
	public Usuario obtenerUsuario(String login) throws MyException {
		Usuario usuario = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("Login", login));
			usuario = (Usuario) session.get(Usuario.class, login);
		} catch (Exception e) {
			throw new MyException(e);
		}finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					session.close();
				}
				
			}
		}
		return usuario;
		
	}

	@Override
	public void guardar(Usuario Usuario) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.save(Usuario);
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
	public void actualizar(Usuario Usuario) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.update(Usuario);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		}finally{
			if (session!=null) {
				try {
					session.update(Usuario);
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
		

	}

	@Override
	public void eliminar(Usuario Usuario) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.delete(Usuario);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		}finally{
			if (session!=null) {
				try {
					session.delete(Usuario);
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}

	}

}
