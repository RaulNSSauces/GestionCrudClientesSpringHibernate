package es.gestioncrud.dao;

import java.util.List;

import es.gestioncrud.model.Cliente;

public interface ClienteDAO {
	
	public List<Cliente> getClientes();

	public void insertarCliente(Cliente nuevoCliente);

	public Cliente getCliente(int id);

	public void eliminarCliente(int id);

}
