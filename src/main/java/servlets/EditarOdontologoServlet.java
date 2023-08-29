
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Odontologo;


@WebServlet(name = "EditarOdontologoServlet", urlPatterns = {"/editarOdontologo"})
public class EditarOdontologoServlet extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        int id = Integer.parseInt(request.getParameter("id"));
        
        Odontologo odon = controladora.traerOdontologo(id);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("editarOdontologo", odon);
        response.sendRedirect("editarOdontologo.jsp");
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
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String especialidad = request.getParameter("especialidad");
        String username = request.getParameter("username");
        String idHorario = request.getParameter("idHorario");
        
        Odontologo odon = (Odontologo) request.getSession().getAttribute("editarOdontologo");
        
        odon.setNombre(nombre);
        odon.setApellido(apellido);
        odon.setDni(dni);
        odon.setTelefono(telefono);
        odon.setDireccion(direccion);
        odon.setEspecialidad(especialidad);
        
        controladora.editarOdontologo(odon);
        response.sendRedirect("odontologos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
