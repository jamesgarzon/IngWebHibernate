package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

public interface ClienteDao {
	List<Cliente> obtener() throws MyException;
	Cliente obtener(String cedula) throws MyException;
	void guardar(Cliente Cliente) throws MyException;
	void actualizar(Cliente Cliente) throws MyException;
	void eliminar(Cliente Cliente) throws MyException;
}
