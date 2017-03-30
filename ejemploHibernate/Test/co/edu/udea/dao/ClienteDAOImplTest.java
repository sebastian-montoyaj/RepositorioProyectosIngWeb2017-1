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
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar()
	{
		Cliente cliente = null;
		ClienteDAO clienteDAO = null;
		Usuario user = null;
		
		try
		{
			cliente = new Cliente();
			cliente.setCedula("1152189976");
			cliente.setNombres("Sebastian");
			cliente.setApellidos("Montoya");
			cliente.setEmail("mono@udea.edu.co");
			
			user = new Usuario();
			user.setLogin("elver");
			cliente.setUsuarioCrea(user);
			cliente.setFechaCreacion(new Date());
			
			
			clienteDAO = new ClienteDAOImpl();
			clienteDAO.guardar(cliente);
		}
		catch(Excepcion e)
		{
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
