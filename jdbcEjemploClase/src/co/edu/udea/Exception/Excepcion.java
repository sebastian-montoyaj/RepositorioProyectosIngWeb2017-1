/* Clase personalizada para manejar todos los errores que puedan ocurrir en este proyecto*/
package co.edu.udea.Exception;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class Excepcion extends Exception
{

	public Excepcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Excepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public Excepcion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public Excepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Excepcion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
