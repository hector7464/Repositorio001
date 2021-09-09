package com.hemimaje.demo.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hemimaje.demo.interfaceServicios.IpersonaService;
import com.hemimaje.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {
	//Para implementar el método listar vamos a crear un objeto service de Interfaz Persona Service
	@Autowired
	private IpersonaService service;
	
	//crearemos el método listar
	@GetMapping("/listar")
	public String listar(Model model) {
		
		
		List<Persona>personas = service.listar();//método listar tiene un valor de retorno de tipo List
		model.addAttribute("personas",personas); //con model y add vamos a enviar toda la lista al formulario
		return "index";
		
	}
	
	//Creamos el método agregar personas
	//Cuando el usuario teclee en el boton Nuevo llama a model y mostrará el formulario 
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());//el usuario presioan el botón
		return "form"; //muestra el formulario
	}
	
	//Creamos método que permite guardar el nuevo dato creado
	@PostMapping("/save")
	public String save (@Validated Persona p, Model model) {
		service.save(p);//con el método service guarda los datos en la bd
		return "redirect:/listar"; //Cuando el usuario presione el boton GUARDAR lo redirecciona a la página de listar
	}
	
	//creamos método para actualizar los datos de los empleados
	@GetMapping("/editar/{id}")
	//el método debe recibir el parámetro id para ello utilizamos PathVariable
	public String editar(@PathVariable int id, Model model) {
		//se crea una variable opcional del objeto persona y pasamos el id
		Optional<Persona> persona = service.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
}
