package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.dto.DireccionId;
import co.edu.udea.iw.exception.MyException;

public class DireccionDaoImplTest {

//	@Test
	public void testObtener() {
		DireccionDaoImp dao= null;
        List<Direccion> lista = null;
        int total = 1;

        try {
            // Act
            dao = new DireccionDaoImp();
            lista = dao.obtener();
            // Assert
            System.out.println("Aqui se listan las direcciones existentes..");
            for(Direccion direccion :lista){
            	System.out.println("Nombre: "+ direccion.getDireccion());
            }
            assertTrue(total <= lista.size());
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

//	@Test
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
			fail(e.getMessage());
		}
				
	}

//	@Test
	public void testGuardar() throws MyException {
		DireccionDaoImp dao = null;
		Direccion direccion = null;
		Direccion direccionConsulta = null;
		DireccionId direccionId = null;
		DireccionId direccionIdConsulta = null;
		ClienteDaoImp daoCliente = null;
		Cliente cliente = null;
		CiudadDaoImp daoCiudad= null;
		Ciudad ciudad = null;
		
//		Variables
		String cedulaCliente = "1040040896";
		long codigoIdDireccion = 2;
		int codigoCiudad = 1; 
		String direccionDireccion = "Calle 33 # 44 - 87";
		boolean preferidaDireccion = true;
		String telefonoDireccion = "555-85-55";
		
		try {
			daoCliente = new ClienteDaoImp();
			cliente = new Cliente();
			cliente = daoCliente.obtener(cedulaCliente);
			direccionId = new DireccionId();
			direccionId.setCliente(cliente);
			direccionId.setCodigo(codigoIdDireccion);
			daoCiudad = new CiudadDaoImp();
			ciudad = daoCiudad.obtener(codigoCiudad);
			
			dao = new DireccionDaoImp();
			direccion = new Direccion();
			direccion.setDireccionId(direccionId);
			direccion.setCiudad(ciudad);
			direccion.setDireccion(direccionDireccion);
			direccion.setPreferida(preferidaDireccion);
			direccion.setTelefono(telefonoDireccion);
			dao.guardar(direccion);
			
				// Consulta
			direccionIdConsulta = new DireccionId();
			direccionIdConsulta.setCliente(cliente);
			direccionIdConsulta.setCodigo(codigoIdDireccion);
			direccionConsulta = dao.obtener(direccionIdConsulta);
			System.out.println("Codigo de Dirección:" + direccionConsulta.getDireccionId().getCodigo());
			System.out.println("Cliente cedula: "+ direccionConsulta.getDireccionId().getCliente().getCedula());
			System.out.println("Cliente nombre: "+ direccionConsulta.getDireccionId().getCliente().getNombres());
			System.out.println("Direccion: "+ direccionConsulta.getDireccion());
			System.out.println("Teléfono: "+ direccionConsulta.getTelefono());
			System.out.println("Ciudad código: "+ direccionConsulta.getCiudad().getCodigo());
			System.out.println("Ciudad nombre: "+ direccionConsulta.getCiudad().getNombre());
			assertTrue(direccionConsulta.getCiudad().equals("tt"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

//	@Test
	public void testActualizar() {
		DireccionDaoImp dao = null;
		Direccion direccion = null;
		Direccion direccionConsulta = null;
		DireccionId direccionId = null;
		DireccionId direccionIdConsulta = null;
		ClienteDaoImp daoCliente = null;
		Cliente cliente = null;
		CiudadDaoImp daoCiudad= null;
		Ciudad ciudad = null;
		
//		Variables
		String cedulaCliente = "1040040896";
		long codigoIdDireccion = 1;
		int codigoCiudad = 10; 
		String direccionDireccion = "Avenida siempre viva";
		boolean preferidaDireccion = false;
		String telefonoDireccion = "xxx-xx-xx";
		
		try {
			daoCliente = new ClienteDaoImp();
			cliente = new Cliente();
			cliente = daoCliente.obtener(cedulaCliente);
			
			direccionId = new DireccionId();
			direccionId.setCliente(cliente);
			direccionId.setCodigo(codigoIdDireccion);
			
			daoCiudad = new CiudadDaoImp();
			ciudad = daoCiudad.obtener(codigoCiudad);
			
			dao = new DireccionDaoImp();
			direccion = dao.obtener(direccionId);
			direccion.setCiudad(ciudad);
			direccion.setDireccion(direccionDireccion);
			direccion.setPreferida(preferidaDireccion);
			direccion.setTelefono(telefonoDireccion);
			dao.actualizar(direccion);
			
				// Consulta
			direccionIdConsulta = new DireccionId();
			direccionIdConsulta.setCliente(cliente);
			direccionIdConsulta.setCodigo(codigoIdDireccion);
			direccionConsulta = dao.obtener(direccionIdConsulta);
			System.out.println("Codigo de Dirección:" + direccionConsulta.getDireccionId().getCodigo());
			System.out.println("Cliente cedula: "+ direccionConsulta.getDireccionId().getCliente().getCedula());
			System.out.println("Cliente nombre: "+ direccionConsulta.getDireccionId().getCliente().getNombres());
			System.out.println("Direccion: "+ direccionConsulta.getDireccion());
			System.out.println("Teléfono: "+ direccionConsulta.getTelefono());
			System.out.println("Ciudad código: "+ direccionConsulta.getCiudad().getCodigo());
			System.out.println("Ciudad nombre: "+ direccionConsulta.getCiudad().getNombre());
			assertTrue(	direccionConsulta.getDireccionId().getCodigo() == codigoIdDireccion &&
						direccionConsulta.getDireccionId().getCliente().getCedula().equals(cedulaCliente) &&
						direccionConsulta.getDireccion().equals(direccionDireccion) &&
						direccionConsulta.getTelefono().equals(telefonoDireccion) &&
						direccionConsulta.getCiudad().getCodigo() == codigoCiudad);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminar() {
		DireccionDaoImp dao = null;
		Direccion direccion = null;
		Direccion direccionConsulta = null;
		DireccionId direccionId = null;
		DireccionId direccionIdConsulta = null;
		ClienteDaoImp daoCliente = null;
		Cliente cliente = null;
		CiudadDaoImp daoCiudad= null;
		Ciudad ciudad = null;
		
		String cedulaCliente = "1040040896";
		long codigoIdDireccion = 1;
		
		try {
			daoCliente = new ClienteDaoImp();
			cliente = new Cliente();
			cliente = daoCliente.obtener(cedulaCliente);
			
			direccionId = new DireccionId();
			direccionId.setCliente(cliente);
			direccionId.setCodigo(codigoIdDireccion);
			
			dao = new DireccionDaoImp();
			direccion = dao.obtener(direccionId);
			dao.eliminar(direccion);
			
				// Consulta
			direccionIdConsulta = new DireccionId();
			direccionIdConsulta.setCliente(cliente);
			direccionIdConsulta.setCodigo(codigoIdDireccion);
			direccionConsulta = dao.obtener(direccionIdConsulta);
			assertTrue(	direccionConsulta == null);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
