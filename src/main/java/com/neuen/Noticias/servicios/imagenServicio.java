package com.neuen.Noticias.servicios;

import com.neuen.Noticias.entidades.imagen;
import com.neuen.Noticias.excepciones.MyException;
import com.neuen.Noticias.repositorios.imagenRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NeuenMartinez
 */
@Service
public class imagenServicio {
    
    @Autowired
    private imagenRepositorio imagenRepositorio;

    public imagen guardar(MultipartFile archivo) throws MyException{
        
        if (archivo != null) {
            
            try {
                
              imagen imagen = new imagen();
              imagen.setMime(archivo.getContentType());
              imagen.setNombre(archivo.getName());
              imagen.setContenido(archivo.getBytes());
              
              return imagenRepositorio.save(imagen);
                
            } catch (Exception e) {
                
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    
    public imagen actualizar(MultipartFile archivo, String idImagen)throws MyException{
        
        if (archivo != null) {
            
            try {
                
              imagen imagen = new imagen();
                if (idImagen != null) {
                    Optional<imagen> respuesta = imagenRepositorio.findById(idImagen);
                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }
              imagen.setMime(archivo.getContentType());
              imagen.setNombre(archivo.getName());
              imagen.setContenido(archivo.getBytes());
              
              return imagenRepositorio.save(imagen);
                
            } catch (Exception e) {
                
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
}
