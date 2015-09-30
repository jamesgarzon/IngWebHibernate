package co.edu.udea.iw.dto;

import java.util.Date;

public class Cliente {
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private String usuarioCrea;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModificacion;
	private boolean eliminado;

	private String usuarioElimina;
	private Date fechaEliminacion;
	
	public String getCedula() {
		return cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getEmail() {
		return email;
	}
	public String getUsuarioCrea() {
		return usuarioCrea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public String getUsuarioElimina() {
		return usuarioElimina;
	}
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsuarioCrea(String usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public void setUsuarioElimina(String usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
}
