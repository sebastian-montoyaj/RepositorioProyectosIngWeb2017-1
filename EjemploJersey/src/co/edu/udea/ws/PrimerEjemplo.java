package co.edu.udea.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
@Path("saludo") // Con esta anotacion para definir la ruta o url con la que va a responder el servicio
public class PrimerEjemplo
{
	@GET // Con esta anotacion anoto/registro a que metodo va a responder
	@Produces(MediaType.TEXT_HTML) // Con esta otra le digo que va a entregar, en este caso texto plano
	public String saludar()
	{
		return "Buenas tardes";
	}
	
	@GET // Con esta anotacion anoto/registro a que metodo va a responder
	@Produces(MediaType.APPLICATION_JSON) // Con esta otra le digo que va a entregar, en este caso un json
	@Path("2") // Y con esta instruccion se modifica el path de esta funcion
	public String saludar2()
	{
		return "Desde ing web!!!";
	}
	
	// Usar el complemeto de Chrome: Postman para hacer envios de datos
	
	@POST // Con esta anotacion anoto/registro a que metodo va a responder
	@Produces(MediaType.APPLICATION_XML) // Con esta otra le digo que va a entregar, en este caso un xml
	@Path("3") // Y con esta instruccion se modifica el path de esta funcion
	public String saludar3(@QueryParam("campo1")String nombre) // Anotacion para indicarle que parametros se van a pedir a la url
	{
		return "Buenas tardes: " + nombre;
	}
	// Ejemplo de como se llamaria este metodo:
	// http://localhost:8080/EjemploJersey/jersey/saludo/3?campo1=Sebastian
	
	@POST // Con esta anotacion anoto/registro a que metodo va a responder
	@Produces(MediaType.APPLICATION_XML) // Con esta otra le digo que va a entregar, en este caso un xml
	@Path("4/{campo1}") // Y con esta instruccion se modifica el path de esta funcion
	public String saludar4(@PathParam("campo1")String nombre) // Anotacion para indicarle que parametros se van a pedir a la url
	{
		return "Buenas tardes: " + nombre;
	}
	// Ejemplo de como se llamaria este metodo:
	// http://localhost:8080/EjemploJersey/jersey/saludo/4/Sebastian
}
