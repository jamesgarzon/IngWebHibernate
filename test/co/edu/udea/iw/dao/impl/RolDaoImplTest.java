package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.MyException;

public class RolDaoImplTest {

//	 @Test
	    public void testObtenerRoles() {
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

//	@Test
	public void testObtenerRol() {
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
	
//	@Test
	public void testGuardarRol() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        int codigoCiudad = 1;
        try {
            // Act
            dao = new RolDaoImp();
            rol = new Rol();
            rol.setCodigo("AUX");
            rol.setNombre("Auxiliar");
            dao.guardar(rol);
            // Assert
            rolConsulta = dao.obtener("AUX");
            assertTrue(rolConsulta != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
//	@Test
	public void testActualizarCiudad() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        int codigoRol = 1;
        try {
            // Act
        	rol  = new Rol();
            dao = new RolDaoImp();
            rol =dao.obtener("AUX");
            rol.setNombre("AUXILIAR ADMINISTRATIVO");
            dao.actualizar(rol);
            // Assert
            rolConsulta = dao.obtener("AUX");
            assertTrue(rolConsulta.getNombre().equals("AUXILIAR ADMINISTRATIVO"));
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
	@Test
	public void testEliminarRol() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        int codigoRol = 1;
        try {
            // Act
        	rol  = new Rol();
            dao = new RolDaoImp();
            rol =dao.obtener("AUX");
            dao.eliminar(rol);
            // Assert
            rolConsulta = dao.obtener("AUX");
            assertTrue(rolConsulta == null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

}
