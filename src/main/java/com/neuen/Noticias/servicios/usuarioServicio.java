package com.neuen.Noticias.servicios;

import com.neuen.Noticias.entidades.usuario;
import com.neuen.Noticias.enumeraciones.rol;
import com.neuen.Noticias.excepciones.MyException;
import com.neuen.Noticias.repositorios.usuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NeuenMartinez
 */
@Service
public class usuarioServicio implements UserDetailsService{

    @Autowired
    private usuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrar(String nombreUsuario, String password, String password2) throws MyException{
        
        validar(nombreUsuario, password, password2);
        
        usuario usuario = new usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(rol.USUARIO);
        usuario.setUsuarioalta(new Date());
        
        usuarioRepositorio.save(usuario);
    }
    
    private void validar(String nombreUsuario, String password, String password2) throws MyException{
        
        List<usuario> usuarios = usuarioRepositorio.findAll();
        for (usuario aux : usuarios) {
            if (aux.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                throw new MyException("nombre de usuario ocupado");
            }
        }
        
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new MyException("El nombre de usuario no puede ser nulo o estar vacio");
        }
        if (password == null || password.isEmpty() || password.length() <= 5) {
            throw new MyException("La password no puede ser nula, estar vacia o tener menos de 5 caracteres");
        }
        if (!password.equals(password2)) {
            throw new MyException("Las password ingresadas deben ser iguales");
        }   
    } 

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        
        usuario usuario = usuarioRepositorio.buscarXnombreUsuario(nombreUsuario);
        
        if (usuario != null) {
            
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            
            permisos.add(p);
            
            return new User(usuario.getNombreUsuario(), usuario.getPassword(), permisos);      
        }
        else{
            
            return null;
        }
        
    }
    
}
