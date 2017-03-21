/* Clase que implementa la interfaz DAO de ciudad */
package co.edu.udea.dao;

//Importes necesarios para la clase
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Ciudad;
import co.edu.udea.dao.DataSource;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class CiudadDAOImpl implements CiudadDAO
{
	// Implementacion de los metodos abstractos
	public List<Ciudad> obtener() throws Excepcion
	{
		// Variable con la que vamos a recibir la lista de ciudades
		List<Ciudad> lista = new ArrayList<Ciudad>();
		// Variable con la que se establecera la conexion con la BD
		Session session = null;
		
		try
		{
			// Se inicia la sesion
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class); // Se crea un criterio en donde traeremos todas las ciudades
			lista = criteria.list(); // Luego llevamos todas las ciudades a una lista
			
		}
		// En caso de error recuperamos la excepcion
		catch (HibernateException e)
		{
			throw new Excepcion("Error consultando ciudades", e);
		}
		
		return lista; // Y retornamos la lista de ciudades que recuperamos de la BD
	}
	
	public Ciudad obtener(Long codigo) throws Excepcion
	{
		// Aqui creamos un objeto ciudad para recibir el resultado de la consulta
		Ciudad ciudad = new Ciudad();
		// Variable con la que se establecera la conexion con la BD
		Session session = null;
		
		try
		{
			// Se inicia la sesion
			session = DataSource.getInstance().getSession();
			
			// 1era forma de obtener la ciudad dado el codigo
			/*Criteria criteria = session.createCriteria(Ciudad.class);
			criteria.add(Restrictions.eq("codigo", codigo));
			ciudad = (Ciudad) criteria.uniqueResult();*/
			
			// 2da forma de obtener la ciudad dado el codigo
			//ciudad = (Ciudad)session.get(Ciudad.class, codigo); // Si no encuentra la ciudad retorna nulo
			ciudad = (Ciudad)session.load(Ciudad.class, codigo); // Si no encuentra la ciudad se lanza una excepcion
		}
		// En caso de error recuperamos la excepcion
		catch (HibernateException e)
		{
			throw new Excepcion("Error consultando ciudades", e);
		}
		
		return ciudad; // Y retornamos la ciudad para tal codigo
	}
	
	
	public void guardar(Ciudad ciudad) throws Excepcion
	{
		// Variable de tipo transaccion para poder realizar la inserccion
		Transaction tx = null;
		// Variable con la que se establecera la conexion con la BD
		Session session = null;
		
		try
		{
			// Se inicia la sesion
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction(); // Se da ṕor iniciada la transaccion
			session.save(ciudad); // Se guarda la ciudad en la BD
			tx.commit(); // Y se realiza la confirmacion de la transdaccion
		}
		// En caso de error recuperamos la excepcion
		catch (HibernateException e)
		{
			throw new Excepcion("Error consultando ciudades", e);
		}
		
	}
}
