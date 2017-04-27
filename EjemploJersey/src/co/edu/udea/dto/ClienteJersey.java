package co.edu.udea.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Esta anotacion permite que se convierta este dto automaticamente al formato Json
public class ClienteJersey
{
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	
	public ClienteJersey() // Constructor vacio necesario para jersey
	{}
	
	public ClienteJersey(String cedula, String nombres, String apellidos, String correo) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
