<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<div class="container">
    <h1 class="h3 mb-0 mt-5 text-gray-800 text-center">Clínica Odontólogica</h1>       
</div>

<div class="container col-md-8">
    <div class="p-5">
        <div class="text-center">
            <h3 class="h4 text-gray-900 mb-4">Alta Odontólogo</h3>
            <p class="mb-4">Este es el apartado para dar de alta a los diferentes usuarios del sistema</p>
        </div>
        <div>
            <form action="/odontologos" method="POST" class="user">
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user mb-3" id="nombre"
                           name="nombre" placeholder="Nombre" checked="">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user mb-3" id="apellido"
                           name="apellido" placeholder="Apellido" checked="">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user mb-3" id="dni"
                           name="dni" placeholder="DNI" checked="">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user mb-3" id="telefono"
                           name="telefono" placeholder="+54" checked="">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user mb-3" id="direccion"
                           name="direccion" placeholder="Dirección" checked="">
                </div>
                <div class="col-sm-6">
                    <input type="date" class="form-control form-control-user mb-3" id="fechaNac"
                           name="fecha_nac" placeholder="Fecha de nacimiento" checked="">
                </div>
                <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user mb-3" id="especialidad"
                           name="especialidad" placeholder="Especialidad" checked="">
                </div>
            </div>

            </div>

            <button type="submit" class="btn btn-primary btn-user btn-block">
                Registrar odontólogo
            </button>
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
