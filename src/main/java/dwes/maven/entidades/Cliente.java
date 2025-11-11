package dwes.maven.entidades;

public class Cliente {
	private int Id_cliente;
	private static int siguienteId = 1;
	private String nombre;
	private String email;
	private String DNI;
	private int telefono;

	public Cliente(String nombre, String email, String DNI,int telefono) {
		this.nombre = nombre;
		this.email = email;
		this.Id_cliente = siguienteId;
		this.DNI = DNI;
		this.telefono = telefono;
		siguienteId++;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getId_cliente() {
		return Id_cliente;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDNI() {
		return DNI;
	}

}
