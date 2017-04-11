/* Clase dedicada a realizar pruebas sobre la clase UsuarioDAOImpl */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebastián Montoya Jiménez
 */
@RunWith(SpringJUnit4ClassRunner.class) // Con esto le estamos diciendo al Junit que se usara otro runner para las pruebas
@Transactional // Con esto le indico que esta clase es transaccional
@ContextConfiguration(locations = "classpath:co/edu/udea/config/SpringConf.xml") // Esto le dice a Spring donde esta el archivo de configuracion
public class UsuarioDAOImplTest
{
	@Autowired // Esta anotacion permite la inyeccion de datos desde la BD a esta variable
	UsuarioDAO usuarioDAO;
	
	// Prueba para verificar que el metodo de obtener un usuario este trabajando correctamente
	@Test
	public void testObtener()
	{
		// En primer lugar, se crea un objeto usuario para recibir el resultado de la consulta
		Usuario usuario = null;
		
		try
		{
			// Luego, se realiza la consulta y su resultado es llevado a la variable usuario
			usuario = usuarioDAO.obtener("juan");
			
			// Si el resultado de la consulta es diferente de nulo entonces
			if(usuario != null)
			{
				// Imprimo algunos campos del usuario recuperado solo para comprobar que todo este bien
				System.out.println("Nombres:" + usuario.getNombres() + "\n");
				System.out.println("Apellidos:" + usuario.getApellidos() + "\n");
				System.out.println("Rol:" + usuario.getRoles().getCodigo() + "\n");
			}
			
			// Y de igual modo, si consulta es diferente de nulo entonces el metodo es correcto
			assertTrue(usuario != null);
		}
		catch(Excepcion e)
		{
			fail(e.getMessage()); // En caso de error recupero el mensaje
		}
	}

}
