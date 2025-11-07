package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Vehiculo;

public interface VehiculoDAOInterfaz {
	int insert(Vehiculo vehiculo);
	int update(Vehiculo vehiculo);
	int delete(Vehiculo vehiculo);
	ArrayList<Vehiculo> findall();
	Vehiculo findByMatricula(String matricula);
}
