
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario (String username, String password, String rol){
        Usuario us = new Usuario();
        us.setNombreUsuario(username);
        us.setPassword(password);
        us.setRol(rol);
        controlPersis.crearUsuario(us);
    }

    public List<Usuario> getUsuarios() {
           
       return controlPersis.getUsuarios(); 
    }

    public void borrarUsuario(int id) {
        controlPersis.eliminarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario us) {
        controlPersis.editarUsuario(us);
    }

    public void crearOdontologo(Odontologo odon) {
        controlPersis.crearOdontologo(odon);
    }

    public List<Odontologo> getOdontologos() {
        return controlPersis.getOdontologos();
    }

    public void eliminarOdontologo(int id) {
        controlPersis.eliminarOdontologo(id);
    }

    public Odontologo traerOdontologo(int id) {
       return controlPersis.traerOdontologo(id);
    }

    public void editarOdontologo(Odontologo odon) {
        controlPersis.editarOdontologo(odon);
    }

    public void crearPaciente(Paciente pacien) {
        controlPersis.crearPaciente(pacien);
    }

    public List<Paciente> getPacientes() {
        return controlPersis.getPacientes();
    }

    public void eliminarPaciente(int id) {
        controlPersis.eliminarPaciente(id);
    }

    public Paciente traerPaciente(int id) {
       return controlPersis.traerPaciente(id);
    }

    public void editarPaciente(Paciente pacien) {
        controlPersis.editarPaciente(pacien);
    }

    public boolean comprobarIngreso(String username, String password) {
        
        boolean ingresoValidado = false;
        List<Usuario> listaUsuarios = controlPersis.getUsuarios();
        
        for(Usuario us : listaUsuarios){
        
            if(us.getNombreUsuario().equals(username)){
                if(us.getPassword().equals(password)){
                    
                    ingresoValidado = true;
                }
            }
        }
        return ingresoValidado;
    }
    
    public Usuario usuarioLogueado(String username){
    
        Usuario usuario = new Usuario();
        List<Usuario> listaUsuarios = controlPersis.getUsuarios();
        
        for(Usuario us : listaUsuarios){
        
            if(us.getNombreUsuario().equals(username)){
                usuario = us;
            }
        }    
        return usuario;
    }

    
    public void guardarHorario(String horarioIngreso, String horarioSalida) {
        
        Horario horario = new Horario();
        horario.setHorario_inicio(horarioIngreso);
        horario.setHorario_salida(horarioSalida);
        
        controlPersis.guardarHorario(horario);
    }

    public List<Horario> getHorarios() {
        return controlPersis.getHorario();
    }

    public Horario traerHorario(int idhorario) {
        return controlPersis.traerHorario(idhorario);
    }
    
}
