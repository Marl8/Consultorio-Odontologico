<%@page import="logica.Odontologo"%>
<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<div class="container">
    <h1 class="h3 mb-0 mt-5 text-gray-800 text-center">Clínica Odontólogica</h1>       
</div>

<% Odontologo odon = (Odontologo) request.getSession().getAttribute("editarOdontologo"); %>

<div class="container col-md-8">
    <div class="p-5">
        <div class="text-center">
            <h3 class="h2 mb-4">Edición Odontólogos</h3>
            <p class="mb-4">Este es el apartado para modificar datos de los odontólogos del sistema</p>
        </div>
        <div>
            <form class="user" action="/editarOdontologo" method="POST">

                <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user mb-3" id="nombre"
                           name="nombre" placeholder="Nombre" value="<%= odon.getNombre() %>" checked>
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-3" id="apellido"
                           name="apellido" placeholder="Apellido" value="<%= odon.getApellido()%>" checked>
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="dni"
                           name="dni" placeholder=DNI" value="<%= odon.getDni()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="telefono"
                           name="telefono" placeholder="Teléfono" value="<%= odon.getTelefono()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="direccion"
                           name="direccion" placeholder="Dirección" value="<%= odon.getDireccion()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="especialidad"
                           name="especialidad" placeholder="Especialidad" value="<%= odon.getEspecialidad()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="especialidad"
                           name="username" placeholder="Username" value="<%= odon.getUsuario().getNombreUsuario() %>" disabled checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="especialidad"
                           name="horario" placeholder="Id Horario" value="<%= odon.getHorario().getId_horario() %>" disabled checked="">
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

