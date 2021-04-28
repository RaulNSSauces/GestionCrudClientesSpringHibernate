package es.gestioncrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.gestioncrud.model.Cliente;

@Repository
public class ClienteDAOClase implements ClienteDAO {

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		
		//Obtener la sesión
		
		Session miSesion=sessionFactory.getCurrentSession();
		
		//Crear la consulta a la base de datos
		
		Query<Cliente> miConsulta=miSesion.createQuery("from Cliente", Cliente.class);
		
		//Ejecutar la consulta y devolver los resultados
		
		List<Cliente> clientes=miConsulta.getResultList();
		
		return clientes;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertarCliente(Cliente nuevoCliente) {
		// TODO Auto-generated method stub
		
		//Obtener la sesión
		
		Session miSesion=sessionFactory.getCurrentSession();
		
		//Insertar el cliente
		
		miSesion.saveOrUpdate(nuevoCliente);
		
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		// TODO Auto-generated method stub
		
		//Obtener la sesión
		
		Session miSesion=sessionFactory.getCurrentSession();
		
		//Obtener la información del cliente seleccionado
		
		Cliente nuevoCliente=miSesion.get(Cliente.class, id);
		
		return nuevoCliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		
		//Obtener la sesión
		
		Session miSesion=sessionFactory.getCurrentSession();
		
		//Borrar el cliente de la BD utilizando como criterio su ID correspondiente
		
		Query consulta=miSesion.createQuery("delete from Cliente where id=:idCliente");
		consulta.setParameter("idCliente", id);
		consulta.executeUpdate();
	}

}
