/* Clase que implementa la interfaz DAO de Usuario */
package co.edu.udea.dao;

//Importes necesarios para la clase
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
public class UsuarioDAOImpl implements UsuarioDAO
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
	public Usuario obtener(String login) throws Excepcion
	{
		// Aqui creamos un objeto usuario para recibir el resultado de la consulta
		Usuario user = new Usuario();
		// Variable con la que se establecera la conexion con la BD
		Session session = null;
		
		try
		{
			// Se inicia(Obtiene) la sesion
			session = sessionFactory.getCurrentSession();
			user = (Usuario) session.get(Usuario.class, login); // Si no encuentra el usuario se lanza una excepcion
		}
		// En caso de error recuperamos la excepcion
		catch (HibernateException e)
		{
			//e.printStackTrace();
			throw new Excepcion("Error consultando usuario", e);
		}
		
		return user; // Y retornamos el usuario que recuperamos de la BD
	}

}
