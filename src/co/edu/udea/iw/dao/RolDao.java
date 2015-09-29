package co.edu.udea.iw.dao;

import co.edu.udea.iw.exception.MyException;
import java.util.List;
import co.edu.udea.iw.dto.Rol;

public interface RolDao {
	List<Rol> obtener() throws MyException;
	Rol obtener(String codigo) throws MyException;
	void guardar(Rol rol) throws MyException;
	void actualizar(Rol rol) throws MyException;
	void eliminar(Rol rol) throws MyException;
	
}
