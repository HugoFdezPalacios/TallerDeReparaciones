package dwes.maven.entidades;

public class Vehiculo {
	private int Id_vehiculo;
	private static int siguienteId = 1;
	private String matricula;
	private String marca;
	private String modelo;
	private String dni_cliente;
	private int cliente_id;
	
	public Vehiculo(String matricula, String marca, String modelo, String dni_cliente) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.Id_vehiculo = siguienteId;
		siguienteId++;
		this.cliente_id= cliente_id; //buscaClientePorDNI.getId();
		//Pido el dni del cliente en el constructor para buscar su id medienate el dni.
	}
}
