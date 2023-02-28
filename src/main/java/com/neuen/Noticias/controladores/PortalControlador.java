package com.neuen.Noticias.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NeuenMartinez
 */
@Controller
@RequestMapping("/")
public class PortalControlador {

    @GetMapping("/")
    public String Index(){
        return "index.html";
    }
}
