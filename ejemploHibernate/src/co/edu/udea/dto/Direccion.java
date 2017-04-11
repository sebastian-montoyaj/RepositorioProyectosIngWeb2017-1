/* POJO para la tabla Direcciones*/
package co.edu.udea.dto;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class Direccion
{
	Direccion_ID id; // Clave compuesta
	private String direccion;
	private String telefono;
	private long ciudad;
	private boolean preferida;
	
	public Direccion_ID getId() {
		return id;
	}
	public void setId(Direccion_ID id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public long getCiudad() {
		return ciudad;
	}
	public void setCiudad(long ciudad) {
		this.ciudad = ciudad;
	}
	public boolean isPreferida() {
		return preferida;
	}
	public void setPreferida(boolean preferida) {
		this.preferida = preferida;
	}
	
	
}
