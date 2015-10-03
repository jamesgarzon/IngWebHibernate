package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.dto.DireccionId;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDaoImplTest {

	@Test
	public void test1Obtener() {
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
	public void test4ObtenerCliente() {
		ClienteDaoImp dao = null;
		Cliente cliente = null;
		String cedula = "123456";
		try {
			//Act
			dao = new ClienteDaoImp();
			cliente = new Cliente();
			cliente = dao.obtener(cedula);
			//Assert
			assertTrue(cliente != null);
		} catch (Exception e) {
			fail(e.getMessage());
		}
				
	}

	@Test
	public void test2Guardar() {
		ClienteDaoImp dao= null;
        Cliente cliente = null;
        UsuarioDaoImp daoUsuario = null;
        Usuario usuario = null;
        Cliente clienteConsulta = null;
        
        String login = "juan";
        String cedula = "1040040896";
        String nombres = "James";
        String apellidos = "Garzon Otalvaro";
        String email = "jamesgarzon92@gmail.com";


        try {
            // Act
        	usuario = new Usuario();
        	daoUsuario = new UsuarioDaoImp();
        	usuario = daoUsuario.obtenerUsuario(login);
        	
        	
            dao = new ClienteDaoImp();
            cliente = new Cliente();
            cliente.setCedula(cedula);
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setEmail(email);
            cliente.setUsuarioCrea(usuario);
            cliente.setFechaCreacion(new Date());
            dao.guardar(cliente);
            // Assert
            clienteConsulta = dao.obtener(cedula);
            assertTrue(clienteConsulta != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

	@Test
	public void test3Actualizar() throws MyException {
		ClienteDaoImp dao= null;
        Cliente cliente = null;
        UsuarioDaoImp daoUsuario = null;
        Usuario usuario = null;
        
        Cliente clienteConsulta = null;
        
        String login = "juan";
        String cedula = "1040040896";
        String nombresNuevo = "James Danilo";
        String apellidos = "Garzon Otalvaro";
        String email = "jamesgarzon92@gmail.com";
        
        try {
            // Act
        	usuario = new Usuario();
        	daoUsuario = new UsuarioDaoImp();
        	usuario = daoUsuario.obtenerUsuario(login);
            dao = new ClienteDaoImp();
            cliente = new Cliente();
            cliente = dao.obtener(cedula);
//            cliente.setCedula("300");
            cliente.setNombres(nombresNuevo);
            cliente.setApellidos(apellidos);
            cliente.setEmail(email);
            cliente.setUsuarioCrea(usuario);
            cliente.setFechaCreacion(new Date());
            cliente.setUsuarioModifica(usuario);
            cliente.setFechaModificacion(new Date());
            cliente.setUsuarioElimina(usuario);
            cliente.setFechaEliminacion(new Date());
            dao.actualizar(cliente);
            // Assert
            clienteConsulta = dao.obtener(cedula);
            assertTrue(clienteConsulta.getUsuarioModifica().getLogin().equals(login));
        } catch (MyException e) {
           throw new MyException(e);
        }

	}

	@Test
	public void test5Eliminar() throws MyException {
		ClienteDaoImp dao= null;
        Cliente cliente = null;   
        String cedula = "123456";
        try {
            // Act
            dao = new ClienteDaoImp();
            cliente = dao.obtener(cedula);
            System.out.println("Cliente: "+cliente.getNombres() );
            dao.eliminar(cliente);
        } catch (MyException e) {
        	e.printStackTrace();
//            throw new MyException(e);
         }
	}

}
