package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dwes.maven.controlador.ControladorTaller;
import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.entidades.Cliente;

public class ClienteDAOMysql implements ClienteDAOInterfaz{
	
	private Connection conexion;
	
	public ClienteDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}
	
	
	
	
	@Override
	public void insert(Cliente cliente) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO cliente (id_cliente, nombre, email, dni, telefono) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1); // posicion 1, valor 1
			pst.setString(2, "Gonzalo");
			pst.setInt(3, 35);
			pst.setString(4, "123456789");

			LocalDate fechaToday = LocalDate.now();
			pst.setDate(5, java.sql.Date.valueOf(fechaToday));
			pst.setString(6, ControladorTaller.hashPassword("Dwes123"));
			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		
	}

	@Override
	public void update(Cliente cliente) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT id_cliente, nombre, email, dni, telefono FROM cliente WHERE id_cliente = ?";
			PreparedStatement pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a
																									// cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar

			pst.setInt(1, 15);
			resultado = pst.executeQuery();

			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
//				resultado.updateInt("edad", edadActual + 5);
				resultado.updateRow();
				System.out
						.println("> La edad del cliente  " + nombre + " se modificado a " + resultado.getInt("edad"));
			}

			conexion.commit();
			System.out.println("> Cambios confirmados correctamente");

		} catch (SQLException e) {
			if (conexion != null) {
				try {
					conexion.rollback();
					System.out.println("> Cambios confirmados correctamente");
				} catch (SQLException e1) {
					System.out.println("> NOK:" + e.getMessage());
				}

			}
		} finally {
			if (conexion != null) {
				try {
					conexion.setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
		

	@Override
	public void delete(Cliente cliente) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?;";
		try {
			PreparedStatement pst = conexion.prepareStatement(sqlDelete);
			pst.setInt(1, 1); // borrar id
			int filas = pst.executeUpdate();

			if (filas > 0) {
				System.out.println("> OK. cliente con id 1 eliminada correctamente.");
			} else {
				System.out.println("> NOK. cliente con id 1 no se encuentra en la base de datos.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

