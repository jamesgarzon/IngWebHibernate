package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.dto.DireccionId;
import co.edu.udea.iw.exception.MyException;

public class DireccionDaoImplTest {

	@Test
	public void testObtener() {
		DireccionDaoImp dao= null;
        List<Direccion> lista = null;
        int total = 1;

        try {
            // Act
            dao = new DireccionDaoImp();
            lista = dao.obtener();
            // Assert
            System.out.println("Aqui se listan las direcciones existentes...");
            for(Direccion direccion :lista){
            	System.out.println("Nombre: "+ direccion.getDireccion());
            }
            assertTrue(total <= lista.size());
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

	@Test
	public void testObtenerDireccionId() {
		DireccionDaoImp dao = null;
		Direccion direccion = null;
		DireccionId direccionId = null;
		ClienteDaoImp daoCliente = null;
		Cliente cliente = null;
		try {
			daoCliente = new ClienteDaoImp();
			cliente = new Cliente();
			cliente = daoCliente.obtener("1040040896");
			direccionId = new DireccionId();
			direccionId.setCliente(cliente);
			direccionId.setCodigo(12);
			dao = new DireccionDaoImp();
			direccion = new Direccion();
			direccion = dao.obtener(direccionId);
			System.out.println("Direccion:" + direccion.getDireccion());
			assertTrue(direccion != null);
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}

	@Test
	public void testGuardar() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

}
