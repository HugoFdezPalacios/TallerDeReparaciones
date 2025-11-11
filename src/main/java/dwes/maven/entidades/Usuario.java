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

		public String getDNI() {
			return DNI;
		}

		public int getIdUsuario() {
			return IdUsuario;
		}

		public void setIdUsuario(int idUsuario) {
			IdUsuario = idUsuario;
		}

		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}
}
