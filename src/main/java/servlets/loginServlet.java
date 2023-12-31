
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

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    Controladora controladora = new Controladora();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        
        // Elimina la sesión
        sesion.invalidate();
                
        response.sendRedirect("login.jsp");
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean validarUsuario = false;
        Usuario usuario = new Usuario();
        
        validarUsuario = controladora.comprobarIngreso(username, password);
        if (validarUsuario == true){
            
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("username", username);
            usuario = controladora.usuarioLogueado(username);
            sesion.setAttribute("usuario", usuario);
            
            response.sendRedirect("index.jsp");
            
        }else{
            response.sendRedirect("loginError.jsp");
        }        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
