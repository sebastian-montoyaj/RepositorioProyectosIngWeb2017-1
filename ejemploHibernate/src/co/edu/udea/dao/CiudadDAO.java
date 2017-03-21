/*Interfaz que define el dao de ciudad*/

package co.edu.udea.dao;

// Importes necesarios
import co.edu.udea.dto.Ciudad;
import co.edu.udea.Excepcion.Excepcion;
import java.util.List;

/*
 * @author = Sebastián Montoya Jiménez
 */
public interface CiudadDAO
{
	// Se plantea el metodo abstracto para obtener las ciudades
	public List<Ciudad> obtener() throws Excepcion;
	
	// Se plantea un metodo que me retorna la ciudad especifica dada su clave primaria
	public Ciudad obtener(Long codigo) throws Excepcion;
	
	// Se plantea un metodo que me permite registrar una ciudad en la BD
	public void guardar(Ciudad ciudad) throws Excepcion;
}
