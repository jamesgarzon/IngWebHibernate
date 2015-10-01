package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
public class ClienteDaoImplTest {

//	@Test
	public void testObtener() {
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

//	@Test
	public void testObtenerCliente() {
		ClienteDaoImp dao = null;
		Cliente cliente = null;
		
		try {
			dao = new ClienteDaoImp();
			cliente = new Cliente();
			cliente = dao.obtener("300");
			
			assertTrue(cliente != null);
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}

//	@Test
	public void testGuardar() {
		ClienteDaoImp dao= null;
        Cliente cliente = null;
        UsuarioDaoImp daoUsuario = null;
        Usuario usuario = null;
        
        Cliente clienteConsulta = null;
        try {
            // Act
        	usuario = new Usuario();
        	daoUsuario = new UsuarioDaoImp();
        	usuario = daoUsuario.obtener("juan");
            dao = new ClienteDaoImp();
            cliente = new Cliente();
            cliente.setCedula("1040040896");
            cliente.setNombres("James");
            cliente.setApellidos("Garzon Otalvaro");
            cliente.setEmail("jamesgarzon92@gmail.com");
            cliente.setUsuarioCrea(usuario);
            cliente.setFechaCreacion(new Date());
            dao.guardar(cliente);
            // Assert
            clienteConsulta = dao.obtener("1040040896");
            assertTrue(clienteConsulta != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

	@Test
	public void testActualizar() throws MyException {
		ClienteDaoImp dao= null;
        Cliente cliente = null;
        UsuarioDaoImp daoUsuario = null;
        Usuario usuario = null;
        
        Cliente clienteConsulta = null;
        try {
            // Act
        	usuario = new Usuario();
        	daoUsuario = new UsuarioDaoImp();
        	usuario = daoUsuario.obtener("juan");
            dao = new ClienteDaoImp();
            cliente = new Cliente();
            cliente = dao.obtener("1040040896");
//            cliente.setCedula("300");
            cliente.setNombres("James Danilo");
            cliente.setApellidos("Garzon Otalvaro");
            cliente.setEmail("jamesgarzon92@gmail.com");
            cliente.setUsuarioCrea(usuario);
            cliente.setFechaCreacion(new Date());
            cliente.setUsuarioModifica(usuario);
            cliente.setFechaModificacion(new Date());
            cliente.setUsuarioElimina(usuario);
            cliente.setFechaEliminacion(new Date());
            dao.actualizar(cliente);
            // Assert
            clienteConsulta = dao.obtener("1040040896");
            assertTrue(clienteConsulta.getUsuarioModifica().getLogin().equals("juan"));
        } catch (MyException e) {
           throw new MyException(e);
        }

	}

//	@Test
	public void testEliminar() throws MyException {
		ClienteDaoImp dao= null;
        Cliente cliente = null;   
        Cliente clienteConsulta = null;
        try {
            // Act
            dao = new ClienteDaoImp();
            cliente = new Cliente();
            cliente = dao.obtener("300");
            dao.eliminar(cliente);
        } catch (MyException e) {
            throw new MyException(e);
         }
	}

}
