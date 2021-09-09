package com.hemimaje.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hemimaje.demo.modelo.Persona;

//Extiende de la clase modelo.persona
@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
