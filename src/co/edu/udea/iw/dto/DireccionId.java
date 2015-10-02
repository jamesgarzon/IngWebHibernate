package co.edu.udea.iw.dto;

import java.io.Serializable;

public class DireccionId implements Serializable{
	
	private long codigo;
	private Cliente cliente;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
