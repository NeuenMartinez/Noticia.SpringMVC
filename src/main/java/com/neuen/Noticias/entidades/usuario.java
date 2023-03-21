package com.neuen.Noticias.entidades;
import com.neuen.Noticias.enumeraciones.rol;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author NeuenMartinez
 */
@Entity
public class usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombreUsuario;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date Usuarioalta;
    @Enumerated(EnumType.STRING)
    private rol rol;
    @OneToOne
    private imagen imagen;

    public usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUsuarioalta() {
        return Usuarioalta;
    }

    public void setUsuarioalta(Date Usuarioalta) {
        this.Usuarioalta = Usuarioalta;
    }

    public rol getRol() {
        return rol;
    }

    public void setRol(rol rol) {
        this.rol = rol;
    }
    
    
}
