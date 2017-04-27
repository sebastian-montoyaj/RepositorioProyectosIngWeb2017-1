package co.edu.udea.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.bl.UsuarioBL;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
// Clase que trabajara como servicio web para validar los usuarios
@Path("Usuario") // Con esta anotacion defino la ruta o url con la que va a responder el servicio
@Component // 
public class UsuarioWS
{
	@Autowired // Esta anotacion permite la inyeccion de datos desde la BD a esta variable
	UsuarioBL usuarioBL;
	
	@GET // Con esta anotacion anoto/registro a que metodo va a responder
	@Produces(MediaType.TEXT_HTML)  // Con esta otra le digo que va a entregar, en este caso texto plano
	public String autenticar(@QueryParam("login")String login, @QueryParam("pws")String pws) // @QueryParam :: Anotacion para indicarle que parametros se van a pedir a la url
	{
		boolean resul; // Creo una variable para recibir el resultado de la consulta para validar el usuario
		
		try
		{
			// Se realiza la consulta
			resul = usuarioBL.esUsuarioValido(login, pws);
		}
		catch(Excepcion e) // En caso de error recupero la excepcion
		{
			return e.getMessage();
		}
		
		// Si paso aqui es porque la consulta no tuvo problemas por lo que si la validacion es exitosa entonces
		if (resul)
		{
			// Retorno un mensaje apropiado
			return "Correcto";
		}
		
		// Sino entonces tambien retorno un mensaje apropiado
		return "Incorrecto";
	}
	// Ejemplo: http://localhost:8080/EjemploJersey/jersey/Usuario?login=elver&pws=1g0/KkFdhrmg1DYJWFdd2A==
}
