package co.edu.udea.dto;

import java.io.Serializable;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class Direccion_ID implements Serializable // 
{
	private Long codigo;
	private Cliente cliente;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
