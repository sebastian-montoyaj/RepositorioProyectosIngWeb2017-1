package co.edu.udea.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Cliente;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
// Clase para realizar pruebas sobre la clase de la logica del negocio para los clientes
@RunWith(SpringJUnit4ClassRunner.class) // Con esto le estamos diciendo al Junit que se usara otro runner para las pruebas
@Transactional // Con esto le indico que esta clase es transaccional
@ContextConfiguration(locations = "classpath:co/edu/udea/config/SpringConf.xml") // Esto le dice a Spring donde esta el archivo de configuracion
public class ClienteBLTest
{
	@Autowired // Esta anotacion permite la inyeccion de datos desde la BD a esta variable
	ClienteBL clienteBL; // Creo un objeto ClienteBL para realizar las pruebas [OJO = Este objeto no se debe inicializar!!!]
	
	@Test
	public void testObtener()
	{
		// Ahora creo un objeto para recibir todos los clientes
		List<Cliente> resultado = null;
		
		try
		{
			// Y se obtienen los mismos usando el metodo destinado para ello
			resultado = clienteBL.obtener();
			
			// La prueba es correcta si se obtiene al menos hay un cliente
			assertTrue(resultado.size() > 0);
		}
		catch(Excepcion e) // En caso de error
		{
			// Recupero el mensaje y la prueba falla
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar()
	{
		try
		{
			// Para la prueba, intento guardar el siguiente cliente
			clienteBL.guardar("1111", "Carlos", "Garcia", "carlos.garcia@udea.edu.co", "elver");
			
			// Si se guardo sin problemas la prueba es correcta
			assertTrue(true);
		}
		catch(Excepcion e) // En caso de error
		{
			// Recupero el mensaje y la prueba falla
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
