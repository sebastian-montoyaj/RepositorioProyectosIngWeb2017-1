package co.edu.udea.dao;

//Importes necesarios
import java.util.List;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Cliente;

/* Interfaz que define el dao de cliente
 * @author = Sebastián Montoya Jiménez
 */
public interface ClienteDAO 
{
	// Se plantea el metodo abstracto para obtener todos los clientes
	public List<Cliente> obtener() throws Excepcion;
	
	// Se plantea un metodo que me permite registrar un cliente en la BD
	public void guardar(Cliente cliente) throws Excepcion;
}
