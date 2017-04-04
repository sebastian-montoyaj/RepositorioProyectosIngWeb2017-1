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
	public List<Cliente> obtener() throws Excepcion;
	
	public void guardar(Cliente cliente) throws Excepcion;
}
