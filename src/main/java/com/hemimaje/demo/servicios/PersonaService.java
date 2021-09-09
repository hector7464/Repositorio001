package com.hemimaje.demo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hemimaje.demo.interfaceServicios.IpersonaService;
import com.hemimaje.demo.interfaces.IPersona;
import com.hemimaje.demo.modelo.Persona;

//Implementamos los servicios creados en interfaceService.personaService
@Service
public class PersonaService implements IpersonaService{

	//creamos una variable de la interfaz persona
	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		
		return (List<Persona>)data.findAll(); //utilizamos la variable data y sus métodos en este caso crudrepository
	}

	@Override
	public Optional<Persona> listarId(int id) {
		//este método retorna el objeto con la variable data y método listar por id
		return data.findById(id);
	}

	@Override
	public int save(Persona p) {
		int res=0;//declaramos variable y lo inicializa en 0
		Persona persona = data.save(p);//aquí con esta va a guardar dentro de la db
		if(!persona.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	
	}

}
