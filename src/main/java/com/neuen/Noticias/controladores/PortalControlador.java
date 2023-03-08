package com.neuen.Noticias.controladores;

import com.neuen.Noticias.entidades.noticia;
import com.neuen.Noticias.servicios.noticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NeuenMartinez
 */
@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private noticiaServicio noticiaServicio;
    
    @GetMapping("/")
    public String Index(ModelMap modelo){
        List<noticia> noticia = noticiaServicio.ListaNoticiasOrdenadoPorFecha();
        modelo.addAttribute("noticias",noticia);
        return "index.html";
    }
}
