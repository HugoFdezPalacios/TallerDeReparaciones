package dwes.maven.entidades;

public class Usuario {
	private int IdUsuario;
	private static int siguienteId;
	private String DNI;
	private String nombreUsuario;
	private String password;
	private String rol;
	
		public Usuario(String DNI,String nombreUsuario, String password, String rol ) {
			this.IdUsuario = siguienteId;
			siguienteId++;
			this.DNI = DNI;
			this.nombreUsuario = nombreUsuario;
			this.password = password;
			this.rol = rol;
		}
}
