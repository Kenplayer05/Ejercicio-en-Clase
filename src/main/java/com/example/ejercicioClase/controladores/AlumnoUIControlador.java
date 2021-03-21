
package com.example.ejercicioClase.controladores;


import com.example.ejercicioClase.modelos.personas;
import com.example.ejercicioClase.servicios.alumnoServicio;
import javax.persistence.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlumnoUIControlador {
 @Autowired
private alumnoServicio servicio;

@RequestMapping("/")
public String alumno(Model model){
setParametro(model,"lista", servicio.getTodos());
return "index";
}
@GetMapping("/crear")
public String irCrear(Model model){
setParametro(model, "personas", new personas());
return "alumno";
}

@GetMapping("/actualizar/{id}")
public String irActualizar(@PathVariable("id") Long id, Model model){
setParametro(model, "personas", servicio.getValor(id));
return "alumno";
}
@PostMapping("/guardar")
public String guardar(personas persona, Model model){
servicio.guardar(persona);
return "redirect:/";
}

@GetMapping("/eliminar/{id}")
public String eliminar(@PathVariable("id") Long id, Model model){
servicio.eliminar(id);
return "redirect:/";
}

public void  setParametro(Model model, String atributo, Object valor){
model.addAttribute(atributo, valor);
}  
}
