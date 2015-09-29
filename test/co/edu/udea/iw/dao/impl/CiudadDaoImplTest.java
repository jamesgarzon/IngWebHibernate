package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDaoImplTest {

	 @Test
	    public void testObtenerCiudades() {
		 	CiudadDaoImp dao= null;
	        List<Ciudad> lista = null;
	        int total = 1;

	        try {
	            // Act
	            dao = new CiudadDaoImp();
	            lista = dao.obtener();
	            // Assert
	           
	            assertTrue(total <= lista.size());
	        } catch (MyException e) {
	            fail(e.getMessage());
	        }

	    }

//	@Test
	public void testObtenerCiudad() {
		CiudadDaoImp dao= null;
        Ciudad ciudad = null;
        int codigoCiudad = 1;
        try {
            // Act
            dao = new CiudadDaoImp();
            ciudad = dao.obtener(codigoCiudad);
            // Assert
           
            assertTrue(ciudad != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
//	@Test
	public void testGuardarCiudad() {
		CiudadDaoImp dao= null;
        Ciudad ciudad = null;
        Ciudad ciudadConsulta = null;
        int codigoCiudad = 1;
        try {
            // Act
            dao = new CiudadDaoImp();
            ciudad = new Ciudad();
            ciudad.setCodigo(9);
            ciudad.setCodigoArea("19");
            ciudad.setNombre("La Ceja");
            dao.guardar(ciudad);
            // Assert
            ciudadConsulta = dao.obtener(9);
            assertTrue(ciudadConsulta != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
//	@Test
	public void testActualizarCiudad() {
		CiudadDaoImp dao= null;
        Ciudad ciudad = null;
        Ciudad ciudadConsulta = null;
        int codigoCiudad = 1;
        try {
            // Act
        	ciudad  = new Ciudad();
            dao = new CiudadDaoImp();
            ciudad =dao.obtener(9);
            ciudad.setNombre("La Ceja del Tambo");
            dao.actualizar(ciudad);
            // Assert
            ciudadConsulta = dao.obtener(9);
            assertTrue(ciudadConsulta.getNombre().equals("La Ceja del Tambo"));
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
//	@Test
	public void testEliminarCiudad() {
		CiudadDaoImp dao= null;
        Ciudad ciudad = null;
        Ciudad ciudadConsulta = null;
        int codigoCiudad = 1;
        try {
            // Act
        	ciudad  = new Ciudad();
            dao = new CiudadDaoImp();
            ciudad =dao.obtener(9);
            dao.eliminar(ciudad);
            // Assert
            ciudadConsulta = dao.obtener(4);
            assertTrue(ciudadConsulta == null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

}
