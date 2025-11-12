package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Usuario;

public interface UsuarioDAOInterfaz {
	void login(String dni, String password);
	void insert(Usuario u);
	 ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	ArrayList<Usuario> findall();
	Usuario findByDNI(String dni);
}
