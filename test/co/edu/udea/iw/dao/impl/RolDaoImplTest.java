package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.MyException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RolDaoImplTest {

	 @Test
	    public void test1ObtenerRoles() {
		 	RolDaoImp dao= null;
	        List<Rol> lista = null;
	        int total = 1;
	        
	        try {
	            // Act
	            dao = new RolDaoImp();
	            lista = dao.obtener();
	            // Assert
	            assertTrue(total <= lista.size());
	        } catch (MyException e) {
	            fail(e.getMessage());
	        }

	    }

	@Test
	public void test2ObtenerRol() {
		RolDaoImp dao= null;
        Rol rol = null;
        String codigoCiudad = "AUD";
        try {
            // Act
            dao = new RolDaoImp();
            rol = dao.obtener(codigoCiudad);
            // Assert
           
            assertTrue(rol != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
	@Test
	public void test3GuardarRol() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        String codigo = "AUX";
        String nombre = "Auxiliar";
        try {
            // Act
            dao = new RolDaoImp();
            rol = new Rol();
            rol.setCodigo(codigo);
            rol.setNombre(nombre);
            dao.guardar(rol);
            // Assert
            rolConsulta = dao.obtener(codigo);
            assertTrue(rolConsulta != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
	@Test
	public void test4ActualizarCiudad() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        String codigo = "AUX";
        String nombreNuevo = "AUXILIAR ADMINISTRATIVO";
        try {
            // Act
        	rol  = new Rol();
            dao = new RolDaoImp();
            rol =dao.obtener(codigo);
            rol.setNombre(nombreNuevo);
            dao.actualizar(rol);
            // Assert
            rolConsulta = dao.obtener(codigo);
            assertTrue(rolConsulta.getNombre().equals(nombreNuevo));
        } catch (MyException e) {
            fail(e.getMessage());
        }
	}
	
	@Test
	public void test5EliminarRol() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        String codigo="AUX";
        try {
            // Act
        	rol  = new Rol();
            dao = new RolDaoImp();
            rol =dao.obtener(codigo);
            dao.eliminar(rol);
            // Assert
            rolConsulta = dao.obtener(codigo);
            assertTrue(rolConsulta == null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

}
