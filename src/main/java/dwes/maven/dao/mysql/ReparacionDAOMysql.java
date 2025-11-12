package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.entidades.Reparacion;

public class ReparacionDAOMysql implements ReparacionDAOInterfaz {
	
	private Connection conexion;
	
	public ReparacionDAOMysql () {
		conexion = DBConnection.getInstance().getConnection();
	}
	

	@Override
	public void insert(Reparacion r) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO reparacion (id_reparacion, descripcion, fecha_entrada, coste_estimado, estado, vehiculo_id,cliente_id) VALUES(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1); // posicion 1, valor 1
			pst.setString(2, "Gonzalo");
			pst.setInt(3, 35);
			pst.setString(4, "123456789");
			pst.setDate(5, java.sql.Date.valueOf(r.getFechaEntrada()));
			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		
	}

	@Override
	public void update(Reparacion r) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT id_reparacion, descripcion, fecha_entrada, coste_estimado, estado, vehiculo_id,cliente_id FROM reparaion WHERE id_reparacion = ?";
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
	public void delete(Reparacion r) {
		String sqlDelete = "DELETE FROM reparacion WHERE id_reparacion = ?;";
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
	public ArrayList<Reparacion> findall() {
		return listaReparacioness;
	}

}
