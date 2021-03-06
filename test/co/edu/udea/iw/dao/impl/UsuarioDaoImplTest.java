package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDaoImplTest {

	@Test
	public void test1Obtener() {
		UsuarioDaoImp dao = null;
		List<Usuario> lista = null;
		int total = 1;

		try {
			// Act
			dao = new UsuarioDaoImp();
			lista = dao.obtener();
			// Assert
			for (Usuario usuario : lista) {
				System.out.println("Nombre: " + usuario.getNombres() + " Rol: " + usuario.getRol().getNombre());
			}
			assertTrue(total <= lista.size());
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test2ObtenerUsuario() {
		UsuarioDaoImp dao = null;
		Usuario usuario = null;
		String loginUsuario = "juan";
		try {
			// Act
			dao = new UsuarioDaoImp();
			usuario = dao.obtenerUsuario(loginUsuario);
			// Assert
			assertTrue(usuario != null);
		} catch (MyException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void test3Guardar() {
		UsuarioDaoImp dao = null;
		Usuario usuario = null;
		Usuario usuarioConsulta = null;
		Rol rol = null;
		RolDaoImp rolDao = null;
		String codigoRol = "ADM";
		String login = "James";
		String nombres = "James Danilo";
		String apellidos = "Garzón Otálvaro";
		String contrasena = "cualquiera";
		try {
			// Act
			dao = new UsuarioDaoImp();
			rolDao = new RolDaoImp();
			rol = rolDao.obtener(codigoRol);
			usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setNombres(nombres);
			usuario.setApellidos(apellidos);
			usuario.setContrasena(contrasena);
			usuario.setRol(rol);
			dao.guardar(usuario);
			// Assert
			usuarioConsulta = dao.obtenerUsuario(login);
			assertTrue(usuarioConsulta != null);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test4Actualizar() {
		UsuarioDaoImp dao = null;
		Usuario usuario = null;
		Usuario usuarioConsulta = null;
		Rol rol = null;
		RolDaoImp rolDao = null;
		String codigoRol = "ADM";
		String login = "James";
		String nombresNuevo = "James";
		String apellidosNuevo = "Garzón";
		String contrasenaNueva = "xxxxxxx";
		try {
			// Act
			dao = new UsuarioDaoImp();
			rolDao = new RolDaoImp();
			rol = rolDao.obtener(codigoRol);
			usuario = dao.obtenerUsuario(login);
			usuario.setNombres(nombresNuevo);
			usuario.setApellidos(apellidosNuevo);
			usuario.setContrasena(contrasenaNueva);
			usuario.setRol(rol);
			dao.actualizar(usuario);
			// Assert
			usuarioConsulta = dao.obtenerUsuario(login);
			assertTrue(usuarioConsulta != null);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test5Eliminar() {
		UsuarioDaoImp dao = null;
		Usuario usuario = null;
		Usuario usuarioConsulta = null;
		String login = "James";
		try {
			// Act
			dao = new UsuarioDaoImp();
			usuario = dao.obtenerUsuario(login);
			dao.eliminar(usuario);
			// Assert
			usuarioConsulta = dao.obtenerUsuario(login);
			assertTrue(usuarioConsulta == null);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
