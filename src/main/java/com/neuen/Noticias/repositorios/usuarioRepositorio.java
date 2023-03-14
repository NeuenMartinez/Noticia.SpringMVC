
package com.neuen.Noticias.repositorios;

import com.neuen.Noticias.entidades.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NeuenMartinez
 */
@Repository
public interface usuarioRepositorio extends JpaRepository<usuario, String>{
    @Query("SELECT u FROM usuario u WHERE u.nombreUsuario = :nombreUsuario")
    public usuario buscarXnombreUsuario(@Param("nombreUsuario") String nombreUsuario);
}
