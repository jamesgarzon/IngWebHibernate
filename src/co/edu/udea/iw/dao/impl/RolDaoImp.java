package co.edu.udea.iw.dao.impl;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dao.RolDao;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.MyException;

public class RolDaoImp implements RolDao {

	@Override
	public List<Rol> obtener() throws MyException {
		List<Rol> roles = new ArrayList<Rol>();
		Session session= null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Rol.class);
			roles =criteria.list();
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
		
		return roles;
	}

	@Override
	public Rol obtener(String codigo) throws MyException {
		Rol rol = new Rol();
		Session session= null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Rol.class).add(Restrictions.eq("codigo", codigo));
			rol = (Rol) session.get(Rol.class, codigo); //Si no encuentra el código, retorna un objeto nulo
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
		return rol;
	}
	
	@Override
	public void guardar(Rol rol) throws MyException{
		Session session = null;
		try {
			
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.save(rol);
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
	public void actualizar(Rol rol) throws MyException{
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.update(rol);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		}finally{
			if (session!=null) {
				try {
					session.update(rol);
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
		
	}

	@Override
	public void eliminar(Rol rol) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.delete(rol);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		}finally{
			if (session!=null) {
				try {
					session.delete(rol);
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
		
	}

}
