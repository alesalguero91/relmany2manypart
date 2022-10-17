/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.fiesta.Repository;

import com.example.fiesta.Entity.Fiesta;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FiestaRepository extends CrudRepository<Fiesta, Long>{
    
    Collection<Fiesta> findAll();
}