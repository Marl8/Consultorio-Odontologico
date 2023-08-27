
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
import logica.Paciente;


@WebServlet(name = "PacientesServlet", urlPatterns = {"/pacientes"})
public class PacientesServlet extends HttpServlet {

    Controladora controladora = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Paciente> listaPacientes = new ArrayList<>();
        HttpSession sesion = request.getSession();
        
        listaPacientes = controladora.getPacientes();
        
        sesion.setAttribute("listaPacientes", listaPacientes);
        response.sendRedirect("verPacientes.jsp");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono =request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        boolean obraSocial = Boolean.parseBoolean(request.getParameter("obra_social"));
        String tipoSangre = request.getParameter("tipo_sangre");
        
        
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

        System.out.println(fechaConvertida);
        
        Paciente pacien = new Paciente();
        pacien.setNombre(nombre);
        pacien.setApellido(apellido);
        pacien.setDni(dni);
        pacien.setTelefono(telefono);
        pacien.setDireccion(direccion);
        pacien.setTiene_os(obraSocial);
        pacien.setTipoSangre(tipoSangre);
        pacien.setFecha_nac(fechaNac);
        
        controladora.crearPaciente(pacien);
        
        response.sendRedirect("altaPacientes.jsp");
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
