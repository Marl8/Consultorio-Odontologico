
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paciente;


@WebServlet(name = "editarPacientesServlet", urlPatterns = {"/editarPaciente"})
public class EditarPacientesServlet extends HttpServlet {

  
    Controladora controladora = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Paciente pacien = controladora.traerPaciente(id);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("editarPaciente", pacien);
        response.sendRedirect("editarPaciente.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        boolean obraSocial = Boolean.parseBoolean(request.getParameter("obra_social"));
        String tipoSangre = request.getParameter("tipo_sangre");
        
        Paciente pacien = (Paciente) request.getSession().getAttribute("editarPaciente");
        pacien.setNombre(nombre);
        pacien.setApellido(apellido);
        pacien.setDni(dni);
        pacien.setTelefono(telefono);
        pacien.setDireccion(direccion);
        pacien.setTiene_os(obraSocial);
        pacien.setTipoSangre(tipoSangre);
        
        controladora.editarPaciente(pacien);
        
        response.sendRedirect("pacientes");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
