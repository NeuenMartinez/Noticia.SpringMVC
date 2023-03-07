package com.neuen.Noticias.controladores;

import com.neuen.Noticias.excepciones.MyException;
import com.neuen.Noticias.servicios.noticiaServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NeuenMartinez
 */
@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {

    @Autowired
    private noticiaServicio noticiaServicio;
    
    @GetMapping("/Formulario")
    public String formulario(){
        return "Formulario.html";
    } 
    
    @PostMapping("/envioFormulario")
    public String envioFormulario(@RequestParam(required = false) String titulo, @RequestParam(required = false) String cuerpo, ModelMap modelo){
        
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            modelo.put("exito","La noticia fue cargada correctamente!");
        } catch (MyException ex) {
            Logger.getLogger(NoticiaControlador.class.getName()).log(Level.SEVERE, null, ex);
            modelo.put("error", ex.getMessage());
            return "Formulario.html";
        }
        return "index.html";
    }

}
