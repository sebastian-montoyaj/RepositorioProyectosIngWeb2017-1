/* Clase dedicada a realizar pruebas sobre la clase CiudadDAOIMPL */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Ciudad;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class CiudadDAOImplTest
{

	// Prueba para verificar que el metodo de obtener todas las ciudades este trabajando correctamente
	@Test
	public void testObtener()
	{
		// Siempre declaro los objetos usando la interfaz creada para ello
		CiudadDAO ciudadDAO = null;
		List<Ciudad> lista = null;
		
		try
		{
			// E inicializo dichos objetos con la implementacion de tal interfaz (Es una buena practica de programacion)
			ciudadDAO = new CiudadDAOImpl();
			lista = ciudadDAO.obtener();
			// Se considerara correcto el metodo si hay por lo menos un elemento 
			assertTrue(lista.size() > 0);
		}
		catch(Excepcion e)
		{
			fail(e.getMessage()); // En caso de error recupero el mensaje
			//e.printStackTrace(); // En caso que se desee ver la traza completa de error se descomenta esta linea. Aunque no es una buena practica.
		}
	}

	// Prueba para verificar que el metodo de obtener una ciudad dada su clave si este correcto
	@Test
	public void testObtener2()
	{
		// Nuevamente, creo los objetos para la prueba
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		
		try
		{
			// E inicializo dichos objetos
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(1L);
			// Se considerara correcto el metodo retorna algo diferente de nulo
			assertTrue(ciudad != null);
		}
		catch(Excepcion e)
		{
			fail(e.getMessage()); // En caso de error recupero el mensaje
		}
	}

	@Test
	public void testGuardar()
	{
		fail("Not yet implemented");
	}

}
