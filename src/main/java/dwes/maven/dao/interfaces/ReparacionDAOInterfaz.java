package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Reparacion;

public interface ReparacionDAOInterfaz {
	int insert(Reparacion r);
	int update(Reparacion r);
	int delete(Reparacion r);
	ArrayList<Reparacion> findall();
}
