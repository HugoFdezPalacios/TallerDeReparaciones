package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Reparacion;

public interface ReparacionDAOInterfaz {
	void insert(Reparacion r);
	void update(Reparacion r);
	void delete(Reparacion r);
	ArrayList<Reparacion> findall();
}
