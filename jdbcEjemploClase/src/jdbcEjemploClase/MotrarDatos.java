// Programa para realizar consultas a una BD de MySQL
package jdbcEjemploClase;

// Se realizan los importes necesarios
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class MotrarDatos
{
	public static void main(String[] args)
	{
		consultarCiudades(); // Se llama el metodo que realiza la consulta a la BD
	}
	
	// Metodo para realizar la consulta de las ciudades en la base de datos
	public static void consultarCiudades()
	{
		// Se crean e inicializan las variables necesarias para la conexion y consulta
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// A contuinuacion, se intenta...
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver de conexion con MYSQL
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sebasBD","root","root"); // Crear y abrir la conexion con la base de datos que queremos
			ps = con.prepareStatement("select * from ciudades;"); // Luego, se construye la consulta
			rs = ps.executeQuery(); // Y realizamos la consulta de las ciudades
			
			// Mientras, haya datos que leer haga
			while(rs.next())
			{
				// Imprima: El codigo de la ciudad y su nombre
				System.out.println(rs.getString("codigo") + ":" + rs.getString("Nombre"));
			}
		}
		// En caso de error se recogen las excepciones
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		// Finalmente, se cierran las conexiones en el orden inverso que las creamos
		finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			}
			// En caso de cualquier otro error se recoge y se imprime
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
