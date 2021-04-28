package es.gestioncrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.gestioncrud.dao.ClienteDAO;
import es.gestioncrud.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	@RequestMapping("/lista")
	public String listaClientes(Model modelo) {
		
		//Obtener los clientes desde el DAO
		
		List<Cliente> losClientes=clienteDAO.getClientes();
		
		//Agregar los clientes al modelo
		
		modelo.addAttribute("clientes", losClientes);
		
		return "listaClientes";
	}
	
	@RequestMapping("/altaCliente")
	public String altaCliente(Model modelo) {
		
		Cliente nuevoCliente=new Cliente();
		
		modelo.addAttribute("cliente", nuevoCliente);
		
		return "altaCliente";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente nuevoCliente) {
		
		// Insertar Cliente en la base de datos
		
		clienteDAO.insertarCliente(nuevoCliente);
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/actualizarCliente")
	public String formularioActualizarCliente(@RequestParam("idCliente") int Id, Model modelo) {
		//Obtener el cliente
		
		Cliente nuevoCliente=clienteDAO.getCliente(Id);
		
		//Establecer el cliente como atributo del modelo
		
		modelo.addAttribute("cliente", nuevoCliente);
		
		//Enviar al formulario
		
		return "altaCliente";
	}
	
	@GetMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam("idCliente") int Id) {
		//Eliminar el cliente
		
		clienteDAO.eliminarCliente(Id);
		
		//Redireccionar a la lista de clientes
		
		return "redirect:/cliente/lista";
	}
	
	@Autowired
	private ClienteDAO clienteDAO;

}
