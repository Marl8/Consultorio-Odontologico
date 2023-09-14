<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<div class="container">
    <h1 class="h3 mb-0 mt-5 text-gray-800 text-center">Clínica Odontólogica</h1>       
</div>

<div class="container">
    <div class="p-5">
        <div>
            <h3 class="h2 mb-4">Nuevo Turno</h3>
            <h3 class="h5 mb-4">Datos Paciente:</h3>
        </div>
       <div>
            <form class="user" action="" method="POST">

                <div class="col-sm-7 mb-3 mb-sm-0">
                    <label>Nombre</label>
                    <input type="text" class="form-control mb-3" id="nombre"
                           name="nombre" placeholder="Nombre" checked="">
                </div>
                <div class="col-sm-7">
                    <label>Apellido</label>
                    <input type="text" class="form-control mb-3" id="apellido"
                           name="apellido" placeholder="Apellido" checked="">
                </div>
                <div class="col-sm-4">
                    <label>Seleccione un Odontólogo</label>
                    <select type="text" class="form-control mb-3 text-center" id="rol"
                        name="odontologo"checked="">
                        <option select value="0">Seleccione un Odontólogo</option>  
                        <option value="2">Juan Perez</option>
                        <option value="3">Manuel Sanchez</option>
                        <option value="4">Alfredo Stain</option>
                        <option value="5">Ana Fernandez</option>
                        <option value="6">Guillermina Alvarez</option>
                        <option value="26">Anibal Pratto</option>
                        <option value="27">Fernanda Nadal</option>
                        <option value="28">Daniel Flores</option>
                        <option value="29">Fabian Zapata</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <label>Fecha del Turno</label>
                    <input type="date" class="form-control mb-3" id="fecha"
                           name="fecha" placeholder="dd/MM/aaaa" checked="">
                </div>
                 <div class="col-sm-4">
                    <label>Seleccione un Horario</label>
                    <select class="form-control mb-5 text-center" id="horario"
                            name="horario"checked="">
                        <option select value="0">Seleccione un Horario</option>  
                    </select>
                </div>   
                <div class="col-sm-7">
                    <button class="btn btn-primary btn-user btn-block" type="submit">
                        Generar Turno
                    </button>
                </div>    
            </form>
         </div>  
    </div>
</div>

<%@include file="/views/components/footer.jsp"%>
