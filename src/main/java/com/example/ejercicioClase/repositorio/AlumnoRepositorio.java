/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejercicioClase.repositorio;

import com.example.ejercicioClase.modelos.personas;
import org.springframework.data.repository.CrudRepository;


public interface AlumnoRepositorio extends CrudRepository<personas, Long>  {
    
}
