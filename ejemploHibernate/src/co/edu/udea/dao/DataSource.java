/* Clase que entrega una conexion activa con la BD y que aplica el patron de diseño singleton*/
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
	
	private DataSource()
	{
		
	}
	
	// Metodo con el cual se obtiene o se crea la conexion a la base dew datos
	public Session getSession() throws Excepcion
	{
		try
		{
			// De este modo, si el objeto conexion no se ha creado entonces
			if (factory == null)
			{
				// De acuerdo al archivo de aconfiguracion
				conf.configure("co/edu/udea/config/hibernateConfig.cfg.xml");
				// Se procede a crear la sesion
				factory = conf.buildSessionFactory();
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			throw new Excepcion("Error configurando la sesion", e);
		}
		
		return factory.openSession(); // Al final retorno una sesion abierta de la base de datos
	}
	
	public static DataSource getInstance()
	{
		if (instancia == null)
		{
			instancia = new DataSource();
		}
		
		return instancia;
	}
}
