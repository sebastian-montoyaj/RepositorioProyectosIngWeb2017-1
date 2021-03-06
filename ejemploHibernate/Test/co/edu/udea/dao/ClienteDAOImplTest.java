/* Clase dedicada a realizar pruebas sobre la clase ClienteDAOImpl */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Cliente;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
public class ClienteDAOImplTest
{
	// Prueba para verificar que el metodo de obtener todos los clientes este trabajando correctamente
	@Test
	public void testObtener()
	{
		// En primer lugar, creo los objetos necesarios para la consulta y para recibir el resultado
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		
		try
		{
			// Luego, inicializo el objeto clienteDAO e invoco su metodo para obtener todos lo clientes de la BD
			clienteDAO = new ClienteDAOImpl();
			resultado = clienteDAO.obtener();
			
			// De manera opcional, imprimo el nombre de cada uno de los clientes que pudieron obtenerse de la consulta
			for (Cliente cliente : resultado)
			{
				System.out.println(cliente.getNombres());
			}
			
			// Por tanto, si el numero de clientes es mayor a 0 (O sea, al menos hay un cliente) entonces la prueba es correcta
			assertTrue(resultado.size() > 0);
		}
		// En caso de error recupero el mensaje y la prueba falla
		catch(Excepcion e)
		{
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	// Prueba para verificar que la insercion de un cliente este trabajando correctamente
	@Test
	public void testGuardar()
	{
		// En primer lugar, creo los objetos necesarios para la transaccion
		Cliente cliente = null;
		ClienteDAO clienteDAO = null;
		Usuario user = null;
		
		try
		{
			// Luego, inicializo/creo un cliente ficticio para hacer la prueba
			cliente = new Cliente();
			cliente.setCedula("1152189976");
			cliente.setNombres("Sebastian");
			cliente.setApellidos("Montoya");
			cliente.setEmail("mono@udea.edu.co");
			
			// Lo asocio a algun usuario ya conocido de la base de datos
			user = new Usuario();
			user.setLogin("elver");
			cliente.setUsuarioCrea(user);
			cliente.setFechaCreacion(new Date());
			
			// Y termino de inicializar el objeto clienteDAO para poder invocar su metodo de guardado de clientes
			clienteDAO = new ClienteDAOImpl();
			clienteDAO.guardar(cliente);
		}
		// En caso de error recupero el mensaje y la prueba falla
		catch(Excepcion e)
		{
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
