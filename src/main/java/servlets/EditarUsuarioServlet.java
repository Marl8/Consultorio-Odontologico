
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "editarServlet", urlPatterns = {"/editarUsuario"})
public class EditarUsuarioServlet extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id =Integer.parseInt(request.getParameter("id"));
        Usuario us = controladora.traerUsuario(id);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarioEditar", us);
        response.sendRedirect("editarUsuarios.jsp");
        
        System.out.println("El usuario es:" + us);   
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("username");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
        
        Usuario us = (Usuario) request.getSession().getAttribute("usuarioEditar");
        us.setNombreUsuario(usuario);
        us.setPassword(password);
        us.setRol(rol);
        
        controladora.editarUsuario(us);
        response.sendRedirect("usuarios");
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
