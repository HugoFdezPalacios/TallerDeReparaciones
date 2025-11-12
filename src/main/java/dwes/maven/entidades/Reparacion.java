package dwes.maven.entidades;

import java.time.LocalDate;

public class Reparacion {
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
	
	public Reparacion(String descripcion,double costeEstimado, String estado,String matriculaVehiculo) {
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

	public int getId_reparacion() {
		return Id_reparacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public double getCosteEstimado() {
		return costeEstimado;
	}

	public void setCosteEstimado(double costeEstimado) {
		this.costeEstimado = costeEstimado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
