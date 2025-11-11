package dwes.maven.dao;

import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;
import dwes.maven.dao.mysql.ClienteDAOMysql;
import dwes.maven.dao.mysql.ReparacionDAOMysql;
import dwes.maven.dao.mysql.UsuarioDAOMysql;
import dwes.maven.dao.mysql.VehiculoDAOMysql;

public class MysqlDAOFactory implements DAOFactory{

	public ClienteDAOInterfaz getCLienteDAOInterfaz() {
		return new ClienteDAOMysql();
	}
	
	public VehiculoDAOInterfaz getVehiculoDAOInterfaz() {
		return new VehiculoDAOMysql();
	}
	
	public UsuarioDAOInterfaz getUsuarioDAOInterfaz() {
		return new UsuarioDAOMysql();
	}
	
	public ReparacionDAOInterfaz getReparacionDAOInterfaz() {
		return new ReparacionDAOMysql();
	}
}
