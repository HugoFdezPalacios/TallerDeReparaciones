package dwes.maven.entidades;

public class Vehiculo {
	private int Id_vehiculo;
	private static int siguienteId = 1;
	private String matricula;
	private String marca;
	private String modelo;
	private int cliente_id;
	
	public Vehiculo(String matricula, String marca, String modelo, Cliente cliente) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.Id_vehiculo = siguienteId;
		siguienteId++;
		this.cliente_id= cliente.getId_cliente();	
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}


	public int getId_vehiculo() {
		return Id_vehiculo;
	}

}
