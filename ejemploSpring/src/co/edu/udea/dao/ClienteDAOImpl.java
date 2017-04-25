/* Clase que implementa la interfaz DAO de cliente */
package co.edu.udea.dao;

//Importes necesarios para la clase
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Cliente;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
public class ClienteDAOImpl implements ClienteDAO
{
	// Variable privada que me ayudara a obtener una sesion con la base de datos
	private SessionFactory sessionFactory;
	
	// Metodos getter y setter para establecer la session con la BD
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	// Implementacion de los metodos abstractos
	@Override
	public List<Cliente> obtener() throws Excepcion
	{
		// Aqui creamos un objeto lista de Clientes para recibir el resultado de la consulta
		List<Cliente> clientes = new ArrayList();
		
		Session session = null; // Variable con la que se establecera la conexion/sesion con la BD
		Criteria criteria = null; // Variable con que la cual se aramara la consulta a la BD
		
		try
		{
			// Luego, se inicia(Obtiene) la sesion
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class); // Se define y ejecuta la consulta que traera todas las tuplas de la tabla Cliente
			criteria.addOrder(Order.asc("fechaCreacion")); // Y dichas tuplas se ordenaran ascendentemente por la fecha de creacion 
			
			// Las dos intruciones anteriores serian equivalentes a::: SELECT * Clientes Order by FechaCreacion asc
			
			clientes = criteria.list(); // Ahora, simplemente se tranfiere el resultado de la consulta a la lista vacia que se creo previamente
		}
		// En caso de error recuperamos la excepcion
		catch(HibernateException e)
		{
			throw new Excepcion("Error consultando la lista de clientes", e);
		}
		
		// Y retornamos la lista de clientes que recuperamos de la BD
		return clientes;
	}

	@Override
	public void guardar(Cliente cliente) throws Excepcion
	{
		// Variable con la que se establecera la conexion/sesion con la BD
		Session session = null;
		
		try
		{
			// Se inicia la sesion
			session = sessionFactory.getCurrentSession();
			// Se guarda el cliente en la BD
			session.saveOrUpdate(cliente);
		}
		// En caso de error recuperamos la excepcion
		catch(HibernateException e)
		{
			throw new Excepcion("Ocurrio un error guardando el cliente!", e);
		}
	}
	
}
