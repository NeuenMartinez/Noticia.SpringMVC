package com.neuen.Noticias.controladores;

import com.neuen.Noticias.entidades.noticia;
import com.neuen.Noticias.excepciones.MyException;
import com.neuen.Noticias.servicios.noticiaServicio;
import com.neuen.Noticias.servicios.usuarioServicio;
import java.util.List;
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
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private noticiaServicio noticiaServicio;
    private usuarioServicio usuarioServicio;
    
    @GetMapping("/")
    public String Index(ModelMap modelo){
        List<noticia> noticia = noticiaServicio.ListaNoticiasOrdenadoPorFecha();
        modelo.addAttribute("noticias",noticia);
        return "index.html";
    }
    
    @GetMapping("/registrar")
    public String registrar(){
        return "registro.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombreUsuario,@RequestParam String password,@RequestParam String password2,ModelMap modelo){
        
        try {
            usuarioServicio.registrar(nombreUsuario, password, password2);
            
            modelo.put("exito", "Usuario registrado correctamente!");
            
            return "index.html";
            
        } catch (MyException ex) {
            
            Logger.getLogger(PortalControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            modelo.put("error", ex.getMessage());
            modelo.put("nombreUsuario", nombreUsuario);
            
            return "registro.html";
        }
    }
    
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
}
