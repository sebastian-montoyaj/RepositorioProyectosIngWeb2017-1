/* Clase que implementa la interfaz DAO de ciudad */
package co.edu.udea.dao;

//Importes necesarios para la clase
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.udea.Exception.Excepcion;
import co.edu.udea.dto.Ciudad;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class CiudadDAOImp implements CiudadDAO
{
	// Implementacion del metodo que me obtiene todas las ciudades
	@Override
	public List<Ciudad> obtener() throws Excepcion
	{
		// Variables para realizar la consulta a la BD sobre la tabla de las ciudades
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Ciudad> lista = new  ArrayList<Ciudad>();
		
		// A continuacion...
		try
		{
			con = DataSource.getSingletonConnection(); // Llamo a la funcion que me realiza la conexion con la BD
			ps = con.prepareStatement("select * from ciudades;"); // Luego, se construye la consulta
			rs = ps.executeQuery(); // Y realizamos la consulta de las ciudades
			
			// Ahora, mientras haya datos que leer haga...
			while(rs.next())
			{
				// Creo un nuevo objeto ciudad
				Ciudad ciudad =  new Ciudad();
				
				// Inicializo los atributos de tal objeto con los datos de la tupla que estoy leyendo
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				
				// Y agrego el objeto ciudad a la lista correspondiente
				lista.add(ciudad);
			}
		}
		// En caso de error consultado, lanzo la excepcion apropiada
		catch (SQLException e)
		{
			throw new Excepcion("Error consultando", e);
		}
		// Finalmente, cerramos todas la conexiones abiertas y que ya no usaremos
		finally
		{
			try
			{
				// NOTA: Se cierran las conexiones en el orden inverso que las creamos
				if (rs != null)
				{
					rs.close();
				}
				
				if (ps != null)
				{
					ps.close();
				}
				
				if (con != null)
				{
					con.close();
				}
			}
			// En caso de error, cerrando lanzamos tambien la excepcion apropiada
			catch (SQLException e)
			{
				throw new Excepcion("Error cerrando", e);
			}
		}
		
		// Por ultimo, retornamos en una lista las ciudades que consultamos
		return lista;
	}
	
	// Implementacion del metodo que me obtiene la ciudad con el codigo especificado en los parametros
	@Override
	public Ciudad obtener(Long codigo) throws Excepcion
	{
		// Primero, creamos las variables necesarias para la consulta y las inicializo en nulo (nulo porque si hay un error entonces al menos retorno nulo)
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Ciudad ciudad = null;
		
		// A continuacion...
		try
		{
			// Armo la consulta y la ejecuto. 
			// NOTA: Para evitar SQLInjection, en la creacion de la consulta no se concatena la variable codigo con la instruccion SQL
			//       sino que mas bien que se usa el caracter '?' y con el metodo set__ de PreparedStatement reemplazo dicho caracter por el codigo.
			con = DataSource.getSingletonConnection();
			ps = con.prepareStatement("select * from ciudades where codigo = ?;"); 
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			
			// Despues, si puedo leer el primer y unico elemento de la consulta entonces
			if (rs.next())
			{
				// Inicializo mi variable ciudad con la informacion obtenida de la consulta
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
		}
		// En caso de error consultado, lanzo la excepcion apropiada
		catch (SQLException e)
		{
			throw new Excepcion("Error consultando", e);
		}
		// Finalmente, cerramos todas la conexiones abiertas y que ya no usaremos
		finally
		{
			try
			{
				// NOTA: Se cierran las conexiones en el orden inverso que las creamos
				if (rs != null)
				{
					rs.close();
				}
				
				if (ps != null)
				{
					ps.close();
				}
				
				if (con != null)
				{
					con.close();
				}
			}
			// En caso de error, cerrando lanzamos tambien la excepcion apropiada
			catch (SQLException e)
			{
				throw new Excepcion("Error cerrando", e);
			}
		}
		
		// Por ultimo, retornamos la ciudad que se logro consultar (o nulo en su defecto)
		return ciudad;
	}
}
