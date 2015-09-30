package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

public class ClienteDaoImplTest {

//	@Test
	 public void testObtenerClientes() {
	 	ClienteDaoImp dao= null;
        List<Cliente> lista = null;
        int total = 1;

        try {
            // Act
            dao = new ClienteDaoImp();
            lista = dao.obtener();
            // Assert
            for(Cliente cliente :lista){
            	System.out.println("Nombre: "+ cliente.getNombres());
            }
            assertTrue(total <= lista.size());
        } catch (MyException e) {
            fail(e.getMessage());
        }

    }
	
	@Test
	public void testGuardarCliente() {
		ClienteDaoImp dao= null;
        Cliente cliente = null;
        Cliente clienteConsulta = null;
        try {
            // Act
            dao = new ClienteDaoImp();
            cliente = new Cliente();
            cliente.setCedula("1040040896");
            cliente.setNombres("James");
            cliente.setApellidos("Garzon Otalvaro");
            cliente.setEmail("jamesgarzon92@gmail.com");
            dao.guardar(cliente);
            // Assert
            clienteConsulta = dao.obtener("1040040896");
            assertTrue(clienteConsulta != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

}
	
	
	


