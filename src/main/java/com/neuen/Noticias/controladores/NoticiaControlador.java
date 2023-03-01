package com.neuen.Noticias.controladores;

import com.neuen.Noticias.excepciones.MyException;
import com.neuen.Noticias.servicios.noticiaServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return "formulario.html";
    } 
    
    @PostMapping("/envioFormulario")
    public String envioFormulario(@RequestParam String titulo, String cuerpo){
        
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            return "formulario.html";
        } catch (MyException ex) {
            Logger.getLogger(NoticiaControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "formulario.html";
        }
    }

}
