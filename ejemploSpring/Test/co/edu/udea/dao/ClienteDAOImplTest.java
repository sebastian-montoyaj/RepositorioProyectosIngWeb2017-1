/* Clase dedicada a realizar pruebas sobre la clase ClienteDAOImpl */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Cliente;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebastián Montoya Jiménez
 */
@RunWith(SpringJUnit4ClassRunner.class) // Con esto le estamos diciendo al Junit que se usara otro runner para las pruebas
@Transactional // Con esto le indico que esta clase es transaccional
@ContextConfiguration(locations = "classpath:co/edu/udea/config/SpringConf.xml") // Esto le dice a Spring donde esta el archivo de configuracion
public class ClienteDAOImplTest
{
	@Autowired // Esta anotacion permite la inyeccion de datos desde la BD a esta variable
	ClienteDAO clienteDAO;
	
	// Prueba para verificar que el metodo de obtener todos los clientes este trabajando correctamente
	@Test
	public void testObtener()
	{
		// En primer lugar, creo un objeto lista de clientes para poder rebicir los resultados de la consulta
		List<Cliente> resultado = null;
		
		try
		{
			// Luego, invoco el metodo para obtener todos lo clientes de la BD
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
		// En primer lugar, creo los objetos necesarios para crear un nuevo cliente
		Cliente cliente = null;
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
			
			// Y por ultimo lo guardo en la BD
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
