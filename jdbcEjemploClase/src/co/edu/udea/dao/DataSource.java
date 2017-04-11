/* Clase que entrega una conexion activa con la BD y que aplica el patron de diseño singleton*/
package co.edu.udea.dao;

//Importes necesarios para que esta clase funcione
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import co.edu.udea.Exception.Excepcion;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class DataSource
{
	// En primer lugar creamos una variable privada y estatica de tipo conexion la cual se inicializa en nulo
	private static Connection singletonCon = null;
	
	// Despues creamos un constructor privado, con el cual se busca garantizar una unica instancia de conexion con la BD
	private DataSource() throws Excepcion
	{
		// De este modo se intenta...
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver de conexion con MYSQL
			singletonCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sebasBD","root",""); // Crear y abrir la conexion con la base de datos que queremos
		}
		// En caso de error se recogen las excepciones
		catch(ClassNotFoundException e)
		{
			throw new Excepcion("Driver no enecontrado", e);
		}
		catch(SQLException e)
		{
			throw new Excepcion("No se pudo establecer conexion", e);
		}
	}
	
	// Ahora, se crea un metodo publico que es con el cual otras clases podran acceder a la variable de conexion con la BD
	public static Connection getSingletonConnection() throws Excepcion
	{
		try
		{
			// De este modo, si la conexion con la base de datos es nula o fue cerrada previamente entonces
			if ((singletonCon == null) || (singletonCon.isClosed()))
			{
				new DataSource(); // Se procede a realizar la conexion con la BD
			}
		}
		// En caso de error, se recoge el error
		catch (SQLException e)
		{
			throw new Excepcion("No se pudo establecer conexion", e);
		}
		
		// Y por ultimo, se retorna la variable de conexion
		return singletonCon;
	}
	
}
