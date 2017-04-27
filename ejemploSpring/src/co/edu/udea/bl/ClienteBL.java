package co.edu.udea.bl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.Excepcion.Excepcion;
import co.edu.udea.dao.ClienteDAO;
import co.edu.udea.dao.UsuarioDAO;
import co.edu.udea.dto.Cliente;
import co.edu.udea.dto.Usuario;

/*
 * @author = Sebasti�n Montoya Jim�nez
 */
// Clase que tendra toda la logica del negocio para los clientes
@Transactional // Esto le indica a la clase que las operaciones que se van a hacer son transaccionales contra la BD
public class ClienteBL
{
	// Variable que permitira enlazar/inyectar la informacion de un ClienteDAO con esta clase
	private ClienteDAO clienteDAO;
	// Variable que permitira enlazar/inyectar la informacion de un UsuarioDAO con esta clase
	private UsuarioDAO userDAO;
	
	// Metodos getter/setter para la variable clienteDAO
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}
	
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	// Metodos getter/setter para la variable userDAO
	public UsuarioDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UsuarioDAO userDAO) {
		this.userDAO = userDAO;
	}

	// Metodo que me permitira obtener todos los clientes de la BD
	public List<Cliente> obtener() throws Excepcion
	{
		return clienteDAO.obtener();
	}

	// Metodo que me permitira guardar un nuevo cliente en la BD
	public void guardar(String cedula, String nombres, String apellidos, String email, String usuarioCrea)  throws Excepcion
	{
		// Los siguientes condiciones son para comprobar que los campos no estan vacios
		if (cedula == null || "".equals(cedula))
		{
			throw new Excepcion("La cedula no puede estar vacia!!!");
		}
		
		if (nombres == null || "".equals(nombres))
		{
			throw new Excepcion("El nombre no puede estar vacio!!");
		}
		
		if (apellidos == null || "".equals(apellidos))
		{
			throw new Excepcion("Los apellidos no pueden estar vacios!!");
		}
		
		if (email == null || "".equals(email))
		{
			throw new Excepcion("El email no puede estar vacio!!");
		}
		
		if (usuarioCrea == null || "".equals(usuarioCrea))
		{
			throw new Excepcion("El usuario que crea no puede estar vacio!!");
		}
		
		// Se valida que el email es correcto
		// Se valida que el usuario a crear no exista todavia
		// ---> HACER
		
		// Se valida que el usuario que crea si existe en la BD
		Usuario user = userDAO.obtener(usuarioCrea);
		if (user == null)
		{
			throw new Excepcion("El usuario que crea no existe en la base de datos");
		}
		
		// Se valida que el usuario a crear no exista todavia
		// ---> HACER
		
		// Ahora, se crea un cliente y se setean su informacion
		Cliente cliente  = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(user);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(false);
		
		// Y por ultimo, se guarda como tal el cliente
		clienteDAO.guardar(cliente);
	}

	
}
