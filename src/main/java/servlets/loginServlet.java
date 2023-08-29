
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    Controladora controladora = new Controladora();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean validarUsuario = false;
        
        validarUsuario = controladora.comprobarIngreso(username, password);
        if (validarUsuario == true){
            
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuario", username);
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
