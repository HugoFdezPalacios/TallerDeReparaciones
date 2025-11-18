package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Reparacion;

public interface ReparacionDAOInterfaz {
	void insert(Reparacion r);
	void updateFinalizado(Reparacion r);
	void delete(Reparacion r);
	 ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
	ArrayList<Reparacion> findall();
	void updateEnCurso(Reparacion r);
}
