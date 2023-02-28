package com.neuen.Noticias.servicios;

import com.neuen.Noticias.entidades.noticia;
import com.neuen.Noticias.excepciones.MyException;
import com.neuen.Noticias.repositorios.noticiaRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NeuenMartinez
 */
@Service
public class noticiaServicio {

    @Autowired
    private noticiaRepositorio noticiaRepositorio;
    
    @Transactional
    public void crearNoticia(String titulo, String cuerpo) throws MyException{
        
        validar(titulo, cuerpo);
        
        noticia noticia = new noticia();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setAlta(new Date());
        
        noticiaRepositorio.save(noticia);
    }
    
    public List<noticia> listarNoticias(){
        List<noticia> noticias = new ArrayList<>();
        noticias = noticiaRepositorio.findAll();
        return noticias;
    }
    
    @Transactional
    public void modificarNoticia(String titulo, String cuerpo, String id) throws MyException{
        
        validar(titulo, cuerpo);
        
        Optional<noticia> respuesta = noticiaRepositorio.findById(id);
        
        if (respuesta.isPresent()) {
            noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            
            noticiaRepositorio.save(noticia);
        }
    }
    
    public void validar(String titulo, String cuerpo) throws MyException{
        
        if (titulo == null || titulo.isEmpty()) {
            throw new MyException("El titulo no puede ser nulo");
        }
        if (cuerpo == null || cuerpo.isEmpty()) {
            throw new MyException("El cuerpo no puede ser nulo");
        }
    }
}
