package dwes.maven.entidades;

import java.time.LocalDate;

public class Reparacion {
	private int Id_reparacion;
	private static int siguienteId;
	private String descripcion;
	private LocalDate fechaEntrada;
	private double costeEstimado;
	private String estado;	//Hacer una enumeracion para estado
	private int IdVehiculo;
	private int IdCliente;
	
	public Reparacion(String descripcion,double costeEstimado, String estado,Vehiculo vehiculo) {
		this.Id_reparacion = siguienteId;
		siguienteId++;
		this.descripcion = descripcion;
		this.fechaEntrada = LocalDate.now();
		this.costeEstimado = costeEstimado;
		this.estado = estado;
		this.IdVehiculo = vehiculo.getId_vehiculo();
		this.IdCliente=vehiculo.getCliente_id();
	}

	public int getIdVehiculo() {
		return IdVehiculo;
	}


	public int getIdCliente() {
		return IdCliente;
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
