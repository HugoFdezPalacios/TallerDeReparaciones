package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.entidades.Usuario;

public class UsuarioDAOMysql implements UsuarioDAOInterfaz {
	private Connection conexion;
	
	public UsuarioDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void login(String dni, String password) {
		// Metodo que se utilizara para logearse mediante la validacion de un DNi y una contraseña asociados a un usuario.
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByNombre(String nombre) {
		// Metodo que devolvera un usario a partir de un nombre, en caso de que haya varios se devolveran todos.
		return null;
	}
	
}
