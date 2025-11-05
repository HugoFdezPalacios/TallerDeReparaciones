package dwes.maven.dao.interfaces;



public interface CienteDAOInterfaz {
	int insert(Cliente c);
	int update(Cliente c);
	int delete(Cliente c);
	ArrayList<CLiente c> findall();
	Cliente findByDni(String dni);
}
