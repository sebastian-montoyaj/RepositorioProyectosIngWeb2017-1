/* Clase que entrega una conexion (sesion) activa con la BD y que aplica el patron de diseño singleton*/
package co.edu.udea.dao;

//Importes necesarios para que esta clase funcione
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import co.edu.udea.Excepcion.Excepcion;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class DataSource
{
	// Creamos las variables necesarias para construir una conexion a la BD con Hibernate
	private static DataSource instancia;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	// Constructor privado de la clase que tiene como unico proposito sobreescribir el constructor de la clase padre
	private DataSource()
	{
		
	}
	
	// Metodo con el cual se obtiene o se crea la conexion (sesion) a la base de datos
	public Session getSession() throws Excepcion
	{
		try
		{
			// De este modo, si el objeto conexion (sesion) no se ha creado entonces
			if (factory == null)
			{
				// De acuerdo al archivo de configuracion
				conf.configure("co/edu/udea/config/hibernateConfig.cfg.xml");
				// Se procede a crear la sesion
				factory = conf.buildSessionFactory();
			}
		}
		// En caso de error se recoge la excepcion
		catch (HibernateException e)
		{
			//e.printStackTrace();
			throw new Excepcion("Error configurando la sesion", e);
		}
		
		return factory.openSession(); // Al final retorno una sesion abierta de la base de datos
	}
	
	// Metodo con el cual se verifica y entrega que la sesion este abierta para realizar consultas
	public static DataSource getInstance()
	{
		// De este modo si la sesion es nula entonces
		if (instancia == null)
		{
			// Se procede a realizar la conexion (Osea, abrir la sesion)
			instancia = new DataSource();
		}
		
		// Ahora, independiente de si se acabo de iniciar la sesion o esta ya estuviera abierta, simplemente se retorna tal sesion
		return instancia;
	}
}
