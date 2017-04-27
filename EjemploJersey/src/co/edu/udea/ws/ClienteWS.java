package co.edu.udea.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.bl.ClienteBL;
import co.edu.udea.dto.Cliente;
import co.edu.udea.dto.ClienteJersey;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
// Clase que trabajara como servicio web para ingresar un nuveo cliente a la base de datos
@Path("Cliente") // Con esta anotacion defino la ruta o url con la que va a responder el servicio
@Component // Esta anotacion para que Spring sepa que se van hacer
public class ClienteWS
{
	@Autowired // Esta anotacion permite la inyeccion de datos desde la BD a esta variable
	ClienteBL clienteBL;
	
	@POST // Con esta anotacion anoto/registro a que metodo va a responder
	@Produces(MediaType.TEXT_HTML)  // Con esta otra le digo que va a entregar, en este caso texto plano
	// @QueryParam :: Anotacion para indicarle que parametros se van a pedir a la url
	public void guardarCliente(@QueryParam("cedula")String ced, @QueryParam("nombres")String nom, @QueryParam("apellidos")String ape, @QueryParam("email")String email, @QueryParam("usuarioCrea")String userCrea) throws RemoteException
	{
		try
		{
			// Ahora, se realiza la transaccion para registrar el usuario
			clienteBL.guardar(ced, nom, ape, email, userCrea);
		}
		catch(Excepcion e) // En caso de error se lanza la excepcion
		{
			throw new RemoteException("Error creando el usuario" + e);
		}
	}
	
	@GET // Con esta anotacion anoto/registro a que metodo va a responder
	@Produces(MediaType.APPLICATION_XML) // Con esta otra le digo que va a entregar, en este caso un xml
	 public List<ClienteJersey> obtener() throws RemoteException
	 {
		// Ahora, creo una lista vacia de clientes para recibir el resultado de la consulta
		 List<ClienteJersey> respuesta = new ArrayList<ClienteJersey>();
		 
		 try
		 {
			 // Depues ejecuto la consulta y por cada una de los clinetes los paso al dto que cree para jersey
			 for(Cliente cliente: clienteBL.obtener())
			 {
				 ClienteJersey clienteJersey = new ClienteJersey(cliente.getCedula(), cliente.getNombres(), cliente.getApellidos(), cliente.getEmail());
				 respuesta.add(clienteJersey);
			 }
		 }
		 catch(Excepcion e) // En caso de error lanzo la excepcion
		 {
			 throw new RemoteException("Problema consultando" + e);
		 }
		 
		 return respuesta; // Y retorno la lista de clientes
	 }
	
	// Ejemplo: http://localhost:8080/EjemploJersey/jersey/Cliente
}
