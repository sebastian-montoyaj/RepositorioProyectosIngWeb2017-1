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
@Path("Usuario")
@Component
public class UsuarioWS
{
	@Autowired
	UsuarioBL usuarioBL;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String autenticar(@QueryParam("login")String login, @QueryParam("pws")String pws)
	{
		System.out.println(login);
		boolean resul;
		
		try
		{
			resul = usuarioBL.esUsuarioValido(login, pws);
		}
		catch(Excepcion e)
		{
			return e.getMessage();
		}
		
		if (resul)
		{
			return "";
		}
		
		return "Incorrecto";
	}
	// Ejemplo: http://localhost:8080/EjemploJersey/jersey/Usuario?login=elver&pws=1g0/KkFdhrmg1DYJWFdd2A==
}
