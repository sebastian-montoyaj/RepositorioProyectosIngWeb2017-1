/* Clase que que entrega una conexion activa con la BD*/
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
	// Metodo que establece la conexion con la BD
	public static Connection getConnection() throws Excepcion
	{
		// Se crea e inicializa nula la variable necesaria para la conexion
		Connection con = null;
		
		// A contuinuacion, se intenta...
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver de conexion con MYSQL
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sebasBD","root","root"); // Crear y abrir la conexion con la base de datos que queremos
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
		
		return con; // Y se retorna la variable de conexion
	}
}
