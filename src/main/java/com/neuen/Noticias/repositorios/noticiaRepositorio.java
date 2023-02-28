package com.neuen.Noticias.repositorios;

import com.neuen.Noticias.entidades.noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NeuenMartinez
 */

@Repository
public interface noticiaRepositorio extends JpaRepository<noticia, String>{

    @Query("SELECT n FROM noticia n WHERE n.titulo = :titulo")
    public noticia buscarXTitulo(@Param("titulo") String titulo);
}
