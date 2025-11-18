package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			pst.setInt(1, r.getId_reparacion()); // posicion 1, valor 1
			pst.setString(2, r.getDescripcion());
			pst.setDate(3, java.sql.Date.valueOf(r.getFechaEntrada()));
			pst.setDouble(4, r.getCosteEstimado());
			pst.setString(5, r.getEstado());
			pst.setInt(6,r.getIdVehiculo());
			pst.setInt(7, r.getIdCliente());
			boolean existe = false;

			for (Reparacion rep : listaReparaciones) {
			    if (rep.getId_reparacion() == r.getId_reparacion()) {
			        existe = true;
			        break;
			    }
			}

			if (!existe) {
			    listaReparaciones.add(r);
			}

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		
	}

	@Override
	public void updateEnCurso(Reparacion r) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT id_reparacion, descripcion, fecha_entrada, coste_estimado, estado, vehiculo_id,cliente_id FROM reparaion WHERE id_reparacion = ?";
			PreparedStatement pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a
																									// cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar

			pst.setInt(1, r.getId_reparacion());
			resultado = pst.executeQuery();

			while (resultado.next()) {
	
				resultado.updateString("estado", "en curso");
				resultado.updateRow();
				System.out
						.println("> El estado de la reparación con id  " + r.getId_reparacion()+ " se modificado a " + resultado.getString("estado"));
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
			pst.setInt(1, r.getId_reparacion()); // borrar id
			int filas = pst.executeUpdate();

			if (filas > 0) {
				System.out.println("> OK. reparación con id" + r.getId_reparacion() + " eliminado correctamente.");
				listaReparaciones.remove(r);
			} else {
				System.out.println("> NOK. reparación con id" + r.getId_reparacion() + " no se encuentra en la base de datos.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Reparacion> findall() {
	    return listaReparaciones;
	}
	
	public void VerReparacionesPorEstadisticas() {
		
	}


	@Override
	public void updateFinalizado(Reparacion r) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT id_reparacion, descripcion, fecha_entrada, coste_estimado, estado, vehiculo_id,cliente_id FROM reparaion WHERE id_reparacion = ?";
			PreparedStatement pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a
																									// cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar

			pst.setInt(1, r.getId_reparacion());
			resultado = pst.executeQuery();

			while (resultado.next()) {
	
				resultado.updateString("estado", "finalizado");
				resultado.updateRow();
				System.out
						.println("> El estado de la reparación con id  " + r.getId_reparacion()+ " se modificado a " + resultado.getString("estado"));
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

}
