/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejercicioClase.controladores;

import com.example.ejercicioClase.modelos.personas;
import com.example.ejercicioClase.servicios.alumnoServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ws/persona")
public class AlumnoApiControlador {
     @Autowired
    private alumnoServicio servicio;
    
    @GetMapping(value="/")
    public List<personas> getTodos(){
        return servicio.getTodos();
    }
    
    @GetMapping(value="/{id}")
    public Optional<personas> getValor(@PathVariable Long id){
        return servicio.getValor(id);
    }               
    
    @PostMapping(value="/guardar")
    public personas guardar(@RequestBody personas alumno){
        return servicio.guardar(alumno);
    }
    
    @GetMapping(value="/eliminar/{id}")
    public Optional<personas> eliminar(@PathVariable Long id){
        Optional<personas> alumnoEliminado=servicio.getValor(id);
        servicio.eliminar(id);
        return alumnoEliminado;
    }
}
