
package logica;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Secretario extends Persona{
    
    //private int id_secretario;
    private String sector;
    private Usuario usuario;

    public Secretario() {
    }

    public Secretario(String sector, Usuario usuario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.sector = sector;
        this.usuario = usuario;
    }

    

    /*public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
    }*/

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
