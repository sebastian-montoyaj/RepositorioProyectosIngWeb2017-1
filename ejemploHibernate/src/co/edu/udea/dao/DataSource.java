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
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	// Metodo con el cual se obtiene
	public Session getSession() throws Excepcion
	{
		try
		{
			if (factory == null)
			{
				conf.configure("co/edu/udea/config/hibernateConfig.cfg.xml");
				factory = conf.buildSessionFactory();
			}
			
			return factory.openSession(); // Al final retorno una sesion abierta de la base de datos
		}
		catch (HibernateException e)
		{
			throw new Excepcion("Error configurando la sesion", e);
		}
	}
	
	/*
	private static DataSource instancia;
	
	private DataSource()
	{
		
	}
	
	public static DataSource getInstance()
	{
		if (instancia == null)
		{
			instancia = new DataSource();
		}
		
		return instancia;
	}*/
}
