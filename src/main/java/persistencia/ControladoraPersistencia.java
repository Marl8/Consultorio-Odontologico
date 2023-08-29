
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import logica.Odontologo;
import logica.Paciente;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    HorarioJpaController horarioJPA = new HorarioJpaController();
    OdontologoJpaController odonJPA = new OdontologoJpaController();
    PacienteJpaController pacienJPA = new PacienteJpaController();
    PersonaJpaController persoJPA = new PersonaJpaController();
    ResponsableJpaController respJPA = new ResponsableJpaController();
    SecretarioJpaController secreJP = new SecretarioJpaController();
    TurnoJpaController turnJPA = new TurnoJpaController();
    UsuarioJpaController usJPA = new UsuarioJpaController();


    public void crearUsuario(Usuario us) {
        usJPA.create(us);
    }

    public List<Usuario> getUsuarios() {
        return usJPA.findUsuarioEntities();
    
    }

    public void eliminarUsuario(int id) {
        try {
            usJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("Usuario inexistente " + ex.getMessage());
        }
    }

    public Usuario traerUsuario(int id) {
      return usJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario us) {
        try {
            usJPA.edit(us);
        } catch (Exception ex) {
            System.out.println("Error al editar usuario " + ex.getMessage());
        }
    }

    public void crearOdontologo(Odontologo odon) {
        odonJPA.create(odon);
    }

    public List<Odontologo> getOdontologos() {
       return odonJPA.findOdontologoEntities();
    }

    public void eliminarOdontologo(int id) {
        try {
            odonJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("Error odontologo inexistente " + ex.getMessage());
        }
    }

    public Odontologo traerOdontologo(int id) {
        return odonJPA.findOdontologo(id);
    }

    public void editarOdontologo(Odontologo odon) {
        try {
            odonJPA.edit(odon);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearPaciente(Paciente pacien) {
        pacienJPA.create(pacien);
    }

    public List<Paciente> getPacientes() {
        return pacienJPA.findPacienteEntities();
    }

    public void eliminarPaciente(int id) {
        try {
            pacienJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("Error al eliminar el paciente " + ex.getMessage());
        }    
    }

    public Paciente traerPaciente(int id) {
       return pacienJPA.findPaciente(id);
    }

    public void editarPaciente(Paciente pacien) {
        try {
            pacienJPA.edit(pacien);
        } catch (Exception ex) {
            System.out.println("Error al editar paciente " + ex.getMessage());
        }
    }

    public void guardarHorario(Horario horario) {
               
        horarioJPA.create(horario);        
    }

    public List<Horario> getHorario() {
        return horarioJPA.findHorarioEntities();
    }

    public Horario traerHorario(int idhorario) {
        return horarioJPA.findHorario(idhorario);
    }
    
}
