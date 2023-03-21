package com.neuen.Noticias.controladores;
import com.neuen.Noticias.entidades.noticia;
import com.neuen.Noticias.servicios.noticiaServicio;
import com.neuen.Noticias.servicios.usuarioServicio;
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
@RequestMapping("/admin")
public class AdminControlador {
    
    @Autowired
    private noticiaServicio noticiaServicio;
    
    @Autowired
    private usuarioServicio usuarioServicio;
    
    @GetMapping("/dashboard")
    public String inicioAdmin(ModelMap modelo) {
        List<noticia> noticia = noticiaServicio.ListaNoticiasOrdenadoPorFecha();
        modelo.addAttribute("noticias", noticia);
        return "inicioAdmin.html";
    }
}