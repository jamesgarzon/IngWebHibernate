/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.DireccionDao;
import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.dto.DireccionId;
import co.edu.udea.iw.exception.MyException;

/**
 * @author james
 *
 */
public class DireccionDaoImp implements DireccionDao {

	@Override
	public List<Direccion> obtener() throws MyException {
		List<Direccion> direcciones = new ArrayList<Direccion>();
		Session session= null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Direccion.class);
			direcciones = criteria.list();
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
		return direcciones;
	}

	@Override
	public Direccion obtener(DireccionId direccionId) throws MyException {
		Direccion direccion = new Direccion();
		Session session= null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Direccion.class);
			criteria.add(Restrictions.eq("Codigo", direccionId.getCodigo()));
			criteria.add(Restrictions.eq("Cliente", direccionId.getCliente()));
			direccion = (Direccion) session.get(Direccion.class, direccionId); //Si no encuentra el código, retorna un objeto nulo
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
		return direccion;
	}

	@Override
	public void guardar(Direccion Direccion) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.save(Direccion);
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
	public void actualizar(Direccion Direccion) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.update(Direccion);
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
	public void eliminar(Direccion Direccion) throws MyException {
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			session.delete(Direccion);
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


}
