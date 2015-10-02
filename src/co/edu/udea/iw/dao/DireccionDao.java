package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.dto.DireccionId;
import co.edu.udea.iw.exception.MyException;

public interface DireccionDao {
	List<Direccion> obtener() throws MyException;
	Direccion obtener(DireccionId direccionId) throws MyException;
	void guardar(Direccion Direccion) throws MyException;
	void actualizar(Direccion Direccion) throws MyException;
	void eliminar(Direccion Direccion) throws MyException;
}
