
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String nombreUsuario;
    private String password;
    private String rol;

     public Usuario() {
    }

    public Usuario(int id_suario, String nombreUsuario, String password, String rol) {
        this.id_usuario = id_suario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_suario) {
        this.id_usuario = id_suario;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
