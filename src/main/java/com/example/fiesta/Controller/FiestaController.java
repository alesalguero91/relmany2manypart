/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fiesta.Controller;

import com.example.fiesta.Entity.Fiesta;
import com.example.fiesta.Repository.FiestaRepository;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/fiestas")
public class FiestaController {

	@Autowired
	private FiestaRepository fiestaRepository;
	
	@GetMapping
	public ResponseEntity<Collection<Fiesta>> listarFiestas(){
		return new ResponseEntity<>(fiestaRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fiesta> obtenerFiesta(@PathVariable long id){
		Fiesta fiesta = fiestaRepository.findById(id).orElseThrow(null);
		if(fiesta != null) {
			return new ResponseEntity<>(fiestaRepository.findById(id).orElseThrow(null),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardarFiesta(@RequestBody Fiesta fiesta){
		return new ResponseEntity<>(fiestaRepository.save(fiesta),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarFiesta(@PathVariable long id){
		fiestaRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
