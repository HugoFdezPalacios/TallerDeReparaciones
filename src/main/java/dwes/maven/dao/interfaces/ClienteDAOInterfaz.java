package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Cliente;

public interface ClienteDAOInterfaz {
    void insert(Cliente cliente);
    void update(Cliente cliente);
    void delete(Cliente cliente);
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    ArrayList<Cliente> findAll();
    Cliente findByDni(String dni);
}