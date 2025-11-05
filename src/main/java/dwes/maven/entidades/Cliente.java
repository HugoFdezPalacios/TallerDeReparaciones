package dwes.maven.entidades;

public class Cliente {
	private int Id_cliente;
	private static int siguienteId = 1;
	private String nombre;
	private String email;
	private String DNI;

	public Cliente(String nombre, String email, String DNI) {
		this.nombre = nombre;
		this.email = email;
		this.Id_cliente = siguienteId;
		this.DNI = DNI;
		siguienteId++;
	}
}
