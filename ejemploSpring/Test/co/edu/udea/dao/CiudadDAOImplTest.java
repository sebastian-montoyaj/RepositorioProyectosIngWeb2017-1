/* Clase dedicada a realizar pruebas sobre la clase CiudadDAOIMPL */
package co.edu.udea.dao;

//Importes necesarios para la clase
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Ciudad;

/*
 * @author = Sebastián Montoya Jiménez
 */
@RunWith(SpringJUnit4ClassRunner.class) // Con esto le estamos diciendo al Junit que se usara otro runner para las pruebas
@Transactional // Con esto le indico que esta clase es transaccional
@ContextConfiguration(locations = "classpath:co/edu/udea/config/SpringConf.xml") // Esto le dice a Spring donde esta el archivo de configuracion
public class CiudadDAOImplTest
{
	@Autowired // Esta anotacion permite la inyeccion de datos desde la BD a esta variable
	CiudadDAO ciudadDAO;

	// Prueba para verificar que el metodo de obtener todas las ciudades este trabajando correctamente
	@Test
	public void testObtener()
	{
		// Siempre declaro los objetos usando la interfaz creada para ello
		List<Ciudad> lista = null;
		
		try
		{
			// E inicializo dichos objetos con la implementacion de tal interfaz (Es una buena practica de programacion)
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
		// Igualmente, creo un bojeto ciudad para recibir el resultado de la consulta
		Ciudad ciudad = null;
		
		try
		{
			// Ahora, realizo la consulta segun una clave primaria como por ejemplo 1
			ciudad = ciudadDAO.obtener(1L);
			
			// Y se considerara correcto el metodo cuando se retorna algo diferente de nulo
			assertTrue(ciudad != null);
		}
		catch(Excepcion e)
		{
			fail(e.getMessage()); // En caso de error recupero el mensaje
		}
	}
	
	// Prueba para verificar que la insercion de una ciudad este trabajando correctamente
	@Test
	public void testGuardar()
	{
		// En primer lugar creo un objeto ciudad, el cual transferire a la BD
		Ciudad ciudad = null;
		
		try
		{
			// Enseguida se inicializa el objeto ciudad con la informacion que se quiere guardar
			ciudad = new Ciudad();
			ciudad.setCodigo(12);
			ciudad.setNombre("Leticia");
			ciudad.setCodigoArea("2B");
			
			// Y ahora se invoca el metodo que almacena el objeto ciudad en la BD
			ciudadDAO.guardar(ciudad);
		}
		// En caso de error se recoge el error y se da por fallida la prueba
		catch(Excepcion e)
		{
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
