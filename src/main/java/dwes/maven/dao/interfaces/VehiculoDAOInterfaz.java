package dwes.maven.dao.interfaces;

import java.util.ArrayList;
import dwes.maven.entidades.Vehiculo;

public interface VehiculoDAOInterfaz {
	void insert(Vehiculo vehiculo);
	void update(Vehiculo vehiculo);
	void delete(Vehiculo vehiculo);
	ArrayList<Vehiculo> findall();
	Vehiculo findByMatricula(String matricula);
}
