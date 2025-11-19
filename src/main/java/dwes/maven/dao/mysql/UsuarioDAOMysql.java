package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.entidades.Usuario;
import dwes.maven.utilities.PasswordUtils;

public class UsuarioDAOMysql implements UsuarioDAOInterfaz {
	private Connection conexion;

	public UsuarioDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void login(Usuario u,String DNI, String password) {
		
		if(u.getDNI().equals(DNI) && PasswordUtils.verifyPassword(u.getPassword(), password)){
			
			
			
			
		} else {
			System.out.println("Usuario o contraseña inválidos");
		}
		
	}

	@Override
	public void insert(Usuario u) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO usuario (id_usuario, nombre_usuario, password, rol, dni) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, u.getIdUsuario()); // posicion 1, valor 1
			pst.setString(2, u.getDNI());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getRol());
			pst.setString(5, u.getDNI());

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}

	}

	@Override
	public ArrayList<Usuario> findall() {
		return listaUsuarios;
	}

	@Override
	public Usuario findByDNI(String dni) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getDNI().equals(dni)) {
				return listaUsuarios.get(i);
			}
		}
		return null;
	}

	@Override
	public void login(String dni, String password) {
		// TODO Auto-generated method stub

	}
}
