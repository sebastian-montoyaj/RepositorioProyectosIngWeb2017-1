/* POJO para la tabla usuario*/
package co.edu.udea.dto;

/*
 * @author = Sebastián Montoya Jiménez
 */
public class Usuario
{
	private String login;
	private String nombres;
	private String apellidos;
	private String contrasena;
	private Roles roles; // Clave foranea que enlaza esta tabla con la tabla roles
	
	public String getLogin()
	{
		return login;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	public String getNombres()
	{
		return nombres;
	}
	public void setNombres(String nombre)
	{
		this.nombres = nombre;
	}
	public String getApellidos()
	{
		return apellidos;
	}
	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}
	public String getContrasena()
	{
		return contrasena;
	}
	public void setContrasena(String contrasena)
	{
		this.contrasena = contrasena;
	}
	public Roles getRoles()
	{
		return roles;
	}
	public void setRoles(Roles roles)
	{
		this.roles = roles;
	}
	
	
}
