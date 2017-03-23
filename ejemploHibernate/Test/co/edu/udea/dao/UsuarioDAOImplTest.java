/* Clase dedicada a realizar pruebas sobre la clase UsuarioDAOImpl */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;
import org.junit.Test;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebastián Montoya Jiménez
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
			
			if(usuario != null)
			{
				System.out.println("Nombres:" + usuario.getNombres() + "\n");
				System.out.println("Apellidos:" + usuario.getApellidos() + "\n");
				System.out.println("Rol:" + usuario.getRoles().getCodigo() + "\n");
			}
			
			// Se considerara correcto el metodo cuenado retorna algo diferente de nulo
			assertTrue(usuario != null);
		}
		catch(Excepcion e)
		{
			fail(e.getMessage()); // En caso de error recupero el mensaje
		}
	}

}
