/* Clase personalizada para manejar todos los errores que puedan ocurrir en este proyecto*/
package co.edu.udea.Excepcion;

// Importe necesaruio para la clase
import org.apache.log4j.Logger;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class Excepcion extends Exception
{
	// Bitacora en donde se registraran los errores
	Logger log = Logger.getLogger(this.getClass());

	public Excepcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Excepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		log.error(message, cause); // Se registra el error en la bitacora
		// TODO Auto-generated constructor stub
	}

	public Excepcion(String message, Throwable cause)
	{
		super(message, cause);
		log.error(message, cause); // Se registra el error en la bitacora
		// TODO Auto-generated constructor stub
	}

	public Excepcion(String message) {
		super(message);
		log.error(message); // Se registra el error en la bitacora
		// TODO Auto-generated constructor stub
	}

	public Excepcion(Throwable cause) {
		super(cause);
		log.error(cause); // Se registra el error en la bitacora
		// TODO Auto-generated constructor stub
	}

}