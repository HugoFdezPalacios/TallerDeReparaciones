package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;
import dwes.maven.entidades.Vehiculo;

public class VehiculoDAOMysql implements VehiculoDAOInterfaz{
	private Connection conexion;
	
	public VehiculoDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void insert(Vehiculo vehiculo) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO vehiculo (id_vehiculo, matricula, marca, modelo, cliente_id) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, vehiculo.getId_vehiculo()); // posicion 1, valor 1
			pst.setString(2, vehiculo.getMatricula());
			pst.setString(3, vehiculo.getMarca());
			pst.setString(4, vehiculo.getModelo());
			pst.setInt(5, vehiculo.getCliente_id());

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		
	}

	@Override
	public void update(Vehiculo vehiculo) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT id_vehiculo, matricula, marca, modelo, cliente_id FROM vehiculo WHERE id_vehiculo = ?";
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
	public void delete(Vehiculo vehiculo) {
		String sqlDelete = "DELETE FROM vehiculo WHERE id_vehiculo = ?;";
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
	public ArrayList<Vehiculo> findall() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehiculo findByMatricula(String matricula) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
