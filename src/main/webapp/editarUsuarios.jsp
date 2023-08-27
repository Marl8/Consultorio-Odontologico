<%@page import="logica.Usuario"%>
<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<div class="container">
    <h1 class="h3 mb-0 mt-5 text-gray-800 text-center">Clínica Odontólogica</h1>       
</div>

<% Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioEditar"); %>

<div class="container col-md-8">
    <div class="p-5">
        <div class="text-center">
            <h3 class="h2 mb-4">Edición Usuarios</h3>
            <p class="mb-4">Este es el apartado para modificar datos de los usuarios del sistema</p>
        </div>
        <div>
            <form class="user" action="/editarUsuario" method="POST">

                <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user mb-3" id="username"
                           name="username" placeholder="Username" value="<%= usuario.getNombreUsuario() %>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="password" class="form-control form-control-user mb-3" id="password"
                           name="password" placeholder="Password" value="<%= usuario.getPassword()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="rol"
                           name="rol" placeholder="Rol" value="<%= usuario.getRol()%>" checked="">
                </div>


            </div>
        
            <div class="container">
                <button class="btn btn-primary btn-user btn-block" type="submit">
                Guardar Modificación
            </button>
            </div>    
        </form>
        <hr>
        <div class="text-center">
            <a class="small" href="forgot-password.html">Forgot Password?</a>
        </div>
        <div class="text-center">
            <a class="small" href="login.html">Already have an account? Login!</a>
        </div>
    </div>
</div>
</div>

<%@include file="/views/components/footer.jsp"%>
