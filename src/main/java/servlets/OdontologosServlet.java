
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horario;
import logica.Odontologo;
import logica.Usuario;


@WebServlet(name = "OdontologosServlet", urlPatterns = {"/odontologos"})
public class OdontologosServlet extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List <Odontologo> listaOdontologos = new ArrayList<>();
        HttpSession sesion = request.getSession();
        
        listaOdontologos = controladora.getOdontologos();
        
        sesion.setAttribute("listaOdontologos", listaOdontologos);
        
        response.sendRedirect("verOdontologos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono =request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        int idhorario = Integer.parseInt(request.getParameter("idHorario"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String especialidad = request.getParameter("especialidad");
        
        
        Date fechaNac = convertirFecha(request);
        
        Horario horario = new Horario();
        horario = controladora.traerHorario(idhorario);
        
        Usuario usuario = new Usuario();
        usuario = controladora.traerUsuario(idUsuario);
        
        Odontologo odon = new Odontologo();
        odon.setNombre(nombre);
        odon.setApellido(apellido);
        odon.setDni(dni);
        odon.setTelefono(telefono);
        odon.setDireccion(direccion);
        odon.setEspecialidad(especialidad);
        odon.setHorario(horario);
        odon.setUsuario(usuario);
        odon.setFecha_nac(fechaNac);
        
        controladora.crearOdontologo(odon);
        
        response.sendRedirect("registroExitoso.jsp");
    }

    private Date convertirFecha(HttpServletRequest request) {
        // Convertir fecha de Date.util a Date.sql
        Date fechaNac = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaConvertida = null;
        try {
            fechaNac = formato.parse(request.getParameter("fecha_nac"));
            fechaConvertida = new java.sql.Date(fechaNac.getTime());
        } catch (ParseException ex) {
            System.out.println("Error al parsear la fecha de salida: " + ex.getMessage());
        }
        System.out.println("Fecha Convertida: " + fechaConvertida);
        return fechaNac;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
