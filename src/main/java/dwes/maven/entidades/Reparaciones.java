package dwes.maven.entidades;

import java.time.LocalDate;

public class Reparaciones {
	private int Id_reparacion;
	private static int siguienteId;
	private String descripcion;
	private LocalDate fechaEntrada;
	private double costeEstimado;
	private String estado;	//Hacer una enumeracion para estado
	private String matriculaVehiculo;
	private String DniCliente;
	private int IdVehiculo;
	private int IdCliente;
	
	public Reparaciones(String descripcion,double costeEstimado, String estado,String matriculaVehiculo,String DniCliente) {
		this.Id_reparacion = siguienteId;
		siguienteId++;
		this.descripcion = descripcion;
		this.fechaEntrada = LocalDate.now();
		this.costeEstimado = costeEstimado;
		this.estado = estado;
		this.IdVehiculo = IdVehiculo; // exactamente igual que con el dni.
		this.IdCliente= IdCliente; //buscaClientePorDNI.getId();
		//Pido el dni del cliente en el constructor para buscar su id medienate el dni.
	}
}
