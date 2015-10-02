package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public interface UsuarioDao {
	List<Usuario> obtener() throws MyException;
	Usuario obtenerUsuario(String codigo) throws MyException;
	void guardar(Usuario Usuario) throws MyException;
	void actualizar(Usuario Usuario) throws MyException;
	void eliminar(Usuario Usuario) throws MyException;
}
