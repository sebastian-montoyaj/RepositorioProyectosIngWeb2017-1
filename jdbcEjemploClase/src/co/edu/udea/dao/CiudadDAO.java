/*Interfaz que define el dao de ciudad*/

package co.edu.udea.dao;

// Importes necesarios
import co.edu.udea.Exception.Excepcion;
import co.edu.udea.dto.Ciudad;
import java.util.List;

/*
 * @author = Sebastián Montoya Jiménez
 */
public interface CiudadDAO
{
	// Se plantea el metodo abstracto para obtener todas las ciudades
	public List<Ciudad> obtener() throws Excepcion;
	
	// Se plantea un metodo que me retorna la ciudad especifica dada su clave primaria
	public Ciudad obtener(Long codigo) throws Excepcion;
}
