/* POJO para la tabla ciudad*/
package co.edu.udea.dto;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class Ciudad
{
	private long codigo;
	private String nombre;
	private String codigoArea; // Codigo de area se refiere al codigo postal
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

	public long getCodigo()
	{
		return this.codigo;
	}
	
	public void setCodigo(long codigo)
	{
		this.codigo = codigo;
	}
}