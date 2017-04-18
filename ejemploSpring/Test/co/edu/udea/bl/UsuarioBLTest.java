package co.edu.udea.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.Excepcion.Excepcion;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
// Clase para realizar pruebas sobre la clase de la logica del negocio para los usuarios
@RunWith(SpringJUnit4ClassRunner.class) // Con esto le estamos diciendo al Junit que se usara otro runner para las pruebas
@Transactional // Con esto le indico que esta clase es transaccional
@ContextConfiguration(locations = "classpath:co/edu/udea/config/SpringConf.xml") // Esto le dice a Spring donde esta el archivo de configuracion
public class UsuarioBLTest
{
	@Autowired // Esta anotacion permite la inyeccion de datos desde la BD a esta variable
	UsuarioBL userBL; // Creo un objeto UsuarioBL para realizar las pruebas [OJO = Este objeto no se debe inicializar!!!]

	@Test
	public void testValidarUsuario()
	{
		try
		{
			// El resultado de la prueba dependera del resultado del metodo esUsuarioValido de la clase UsuarioBL
			assertTrue(userBL.esUsuarioValido("elver", "1g0/KkFdhrmg1DYJWFdd2A=="));
		}
		catch(Excepcion e) // En caso de error
		{
			// Recupero el mensaje y la prueba falla
			//e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
