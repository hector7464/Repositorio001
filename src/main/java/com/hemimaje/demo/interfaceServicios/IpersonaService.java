package com.hemimaje.demo.interfaceServicios;

import java.util.List;
import java.util.Optional;
import com.hemimaje.demo.modelo.Persona;

public interface IpersonaService {

	//Los métodos CRUD que se utilizaran 
	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
