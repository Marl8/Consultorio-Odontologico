<%@page import="logica.Paciente"%>
<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<div class="container">
    <h1 class="h3 mb-0 mt-5 text-gray-800 text-center">Clínica Odontólogica</h1>       
</div>

<% Paciente pacien = (Paciente) request.getSession().getAttribute("editarPaciente"); %>

<div class="container col-md-8">
    <div class="p-5">
        <div class="text-center">
            <h3 class="h2 mb-4">Edición Pacientes</h3>
            <p class="mb-4">Este es el apartado para modificar datos de los pacientes del sistema</p>
        </div>
        <div>
            <form class="user" action="/editarPaciente" method="POST">

                <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user mb-3" id="nombre"
                           name="nombre" placeholder="Nombre" value="<%= pacien.getNombre() %>" checked>
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-3" id="apellido"
                           name="apellido" placeholder="Apellido" value="<%= pacien.getApellido()%>" checked>
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="dni"
                           name="dni" placeholder=DNI" value="<%= pacien.getDni()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="telefono"
                           name="telefono" placeholder="Teléfono" value="<%= pacien.getTelefono()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="direccion"
                           name="direccion" placeholder="Dirección" value="<%= pacien.getDireccion()%>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="obra_social"
                           name="obra_social" placeholder="Obra Social" value="<%= pacien.isTiene_os() %>" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-4" id="tipo_sangre"
                           name="tipo_sangre" placeholder="Tipo Sangre" value="<%= pacien.getTipoSangre() %>" checked="">
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

