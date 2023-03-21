package com.neuen.Noticias.repositorios;

import com.neuen.Noticias.entidades.imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NeuenMartinez
 */
@Repository
public interface imagenRepositorio extends JpaRepository<imagen, String>{
    
}
