/* Clase dedicada a realizar pruebas sobre la clase ClienteDAOImpl */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Cliente;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class ClienteDAOImplTest
{

	@Test
	public void testObtener()
	{
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		
		try
		{
			clienteDAO = new ClienteDAOImpl();
			resultado = clienteDAO.obtener();
			
			for (Cliente cliente : resultado)
			{
				System.out.println(cliente.getNombres());
			}
			assertTrue(resultado.size() > 0);
		}
		catch(Excepcion e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
