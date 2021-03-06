/* Clase dedicada a realizar pruebas sobre la clase UsuarioDAOImpl */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;
import org.junit.Test;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
public class UsuarioDAOImplTest
{
	// Prueba para verificar que el metodo de obtener un usuario este trabajando correctamente
	@Test
	public void testObtener()
	{
		// Se crean los objetos necesarios para la prueba
		UsuarioDAO usuarioDAO = null;
		Usuario usuario = null;
		
		try
		{
			// E inicializo dichos objetos y armo la consulta
			usuarioDAO = new UsuarioDAOImpl();
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
