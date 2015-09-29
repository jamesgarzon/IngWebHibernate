package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public interface CiudadDao {
	List<Ciudad> obtener() throws MyException;
	Ciudad obtener(int codigo) throws MyException;
	void guardar(Ciudad ciudad) throws MyException;
	void actualizar(Ciudad ciudad) throws MyException;
	void eliminar(Ciudad ciudad) throws MyException;
}
