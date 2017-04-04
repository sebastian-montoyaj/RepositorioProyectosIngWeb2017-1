package co.edu.udea.dao;

import java.util.List;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Direccion;

/* Interfaz que define el DAO de direccion
 * @author = Sebastián Montoya Jiménez
 */
public interface DireccionDAO
{
	public List<Direccion> obtener() throws Excepcion;
}
