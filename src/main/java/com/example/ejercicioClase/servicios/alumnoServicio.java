/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejercicioClase.servicios;

import com.example.ejercicioClase.modelos.personas;
import com.example.ejercicioClase.repositorio.AlumnoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class alumnoServicio {
    @Autowired
    private AlumnoRepositorio repositorio;
    
    public personas guardar(personas entidad){
    return repositorio.save(entidad);
    }
    public void eliminar(Long id){
    repositorio.deleteById(id);
    }
    
    public Optional<personas> getValor(Long id){
    return repositorio.findById(id);
}
    
    public List<personas> getTodos(){
    return (List<personas>)repositorio.findAll();
    } 
}
