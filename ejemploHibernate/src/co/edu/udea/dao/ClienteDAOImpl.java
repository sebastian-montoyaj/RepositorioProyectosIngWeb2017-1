/* Clase que implementa la interfaz DAO de cliente */
package co.edu.udea.dao;

import java.util.ArrayList;
//Importes necesarios para la clase
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Cliente;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class ClienteDAOImpl implements ClienteDAO
{
	
	@Override
	public List<Cliente> obtener() throws Excepcion
	{
		// Aqui creamos un objeto lista de Clientes para recibir el resultado de la consulta
		List<Cliente> clientes = new ArrayList<>();
		Session session = null;
		Criteria criteria = null;
		
		try
		{
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			
			// SELECT * Clientes Order by FechaCreacion asc
			
			clientes = criteria.list();
		}
		catch(HibernateException e)
		{
			throw new Excepcion("Error consultando la lista de clientes", e);
		}
		
		
		return clientes;
	}

	@Override
	public void guardar(Cliente cliente) throws Excepcion
	{
		Session session = null;
		Transaction tx = null;
		
		try
		{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			
			session.saveOrUpdate(cliente);
			
			tx.commit();
		}
		catch(HibernateException e)
		{
			throw new Excepcion("Ocurrio un error guardando el cliente!", e);
		}
	}


}
