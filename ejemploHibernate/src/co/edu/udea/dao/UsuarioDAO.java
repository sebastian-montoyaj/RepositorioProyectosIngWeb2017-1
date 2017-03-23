/*Interfaz que define el dao de ciudad*/
package co.edu.udea.dao;

//Importes necesarios
import java.util.List;
import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebastián Montoya Jiménez
 */
public interface UsuarioDAO
{
	// Se plantea el metodo abstracto para obtener un usuario especifico
	public Usuario obtener(String login) throws Excepcion;
}
