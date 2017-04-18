package co.edu.udea.bl;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dao.UsuarioDAO;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
// Clase que tendra toda la logica del negocio para los usuarios
public class UsuarioBL
{
	// Variable que permitira enlazar/inyectar la informacion de un UsuarioDAO con esta clase
	private UsuarioDAO userDAO;
	
	// Metodos getter/setter para la variable userDAO
	public UsuarioDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UsuarioDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	// Metodo para validar que el usuario existe en la base de datos
	public boolean esUsuarioValido(String login, String pass) throws Excepcion
	{
		// En primer lugar revisamos que los campos si tengan informacion
		if (login == null || "".equals(login))
		{
			throw new Excepcion("El campo login no debe estar vacio!!!");
		}
		
		if (pass == null || "".equals(pass))
		{
			throw new Excepcion("La contraseña no debe estar vacio!!!");
		}
		
		// Ahora, creamos un objeto usuario que se inicializa con el resultado de la busqueda de tal usuario
		Usuario user = userDAO.obtener(login);
		
		// Luego, si el objeto usuario es nulo entonces este usuario no es valido
		if (user == null)
		{
			return false;
		}
		
		// Si el usuario dado correponde con uno de la base de datos entonces pasamos a comprobar que la contraseña sea correcta, sino lo es entonces tampoco es valido
		if (!user.getContrasena().equals(pass))
		{
			return false;
		}
		
		// NOTA: No es correcto decir que el usuario es correcto pero la contraseña no, porque eso le facilita a usuarios malintecionados vulnerar el sistema
		
		// Finalmente, si tanto usuario como password pasaron las condiciones anteriores entonces retorno que el usuario es valido
		return true;
	}

}
