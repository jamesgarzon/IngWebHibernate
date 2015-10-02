package co.edu.udea.iw.dto;

import java.util.Date;

public class Cliente {
	// Hola BEBES.
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private Usuario usuarioCrea;
	private Date fechaCreacion;
	private Usuario usuarioModifica;
	private Date fechaModificacion;
	private boolean eliminado;

	private Usuario usuarioElimina;
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
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public Usuario getUsuarioModifica() {
		return usuarioModifica;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public Usuario getUsuarioElimina() {
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
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setUsuarioModifica(Usuario usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public void setUsuarioElimina(Usuario usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	

	
}
