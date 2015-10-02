package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDaoImplTest {

	@Test
	public void testObtener() {
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
	public void testObtenerUsuario() {
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
	public void testGuardar() {
		UsuarioDaoImp dao = null;
		Usuario usuario = null;
		Usuario usuarioConsulta = null;
		Rol rol = null;
		RolDaoImp rolDao = null;
		String codigoRol = "ADM";
		String login = "James";
		String nombres = "James Danilo";
		String apellidos = "GarzÃ³n OtÃ¡lvaro";
		String contraseña = "cualquiera";
		try {
			// Act
			dao = new UsuarioDaoImp();
			rolDao = new RolDaoImp();
			rol = rolDao.obtener(codigoRol);
			usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setNombres(nombres);
			usuario.setApellidos(apellidos);
			usuario.setContrasena(contraseña);
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
	public void testActualizar() {
		UsuarioDaoImp dao = null;
		Usuario usuario = null;
		Usuario usuarioConsulta = null;
		Rol rol = null;
		RolDaoImp rolDao = null;
		String codigoRol = "ADM";
		String login = "James";
		String nombresNuevo = "James";
		String apellidosNuevo = "GarzÃ³n";
		String contraseñaNueva = "xxxxxxx";
		try {
			// Act
			dao = new UsuarioDaoImp();
			rolDao = new RolDaoImp();
			rol = rolDao.obtener(codigoRol);
			usuario = dao.obtenerUsuario(login);
			usuario.setNombres(nombresNuevo);
			usuario.setApellidos(apellidosNuevo);
			usuario.setContrasena(contraseñaNueva);
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
	public void testEliminar() {
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
