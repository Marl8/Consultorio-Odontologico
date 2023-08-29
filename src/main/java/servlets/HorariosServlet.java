
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horario;


@WebServlet(name = "HorariosServlet", urlPatterns = {"/horarios"})
public class HorariosServlet extends HttpServlet {

    Controladora controladora = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        List <Horario> listaHorarios = new ArrayList<>();
        
        listaHorarios = controladora.getHorarios();
        sesion.setAttribute("listaHorarios", listaHorarios);
        
        response.sendRedirect("verHorarios.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String horarioIngreso = request.getParameter("horarioIngreso");
        String horarioSalida = request.getParameter("horarioSalida");
        
        controladora.guardarHorario(horarioIngreso, horarioSalida);
        
        response.sendRedirect("altaOdontologos.jsp");        
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
