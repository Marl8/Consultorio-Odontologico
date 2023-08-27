<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Odontólogos</h1>
    <p class="mb-4">Este es el apartado para visualizar a los odontólogos del sistema.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Odontólogos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Especialidad</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th style="width: 25%">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Especialidad</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th style="width: 25%">Acción</th>
                        </tr>
                    </tfoot>
                    <% List<Odontologo> lista = (List) request.getSession().getAttribute("listaOdontologos");%> 
                    
                    <tbody>
                        <%for (Odontologo odon : lista){ %>
                        <tr>
                            <td id= "ide_us <%= odon.getId() %>"><%= odon.getId() %></td>
                             <td><%= odon.getNombre() %></td>
                            <td><%= odon.getApellido() %></td>
                            <td><%= odon.getEspecialidad() %></td>
                            <td><%= odon.getDireccion() %></td>
                            <td><%= odon.getTelefono() %></td>
                            <td style=" display: flex;">
                                <div class="me-5">
                                <form name="eliminar" action="/eliminarOdontologo" method="POST" style="margin-right: 1rem">
                                    <button type="submit" class="btn btn-danger btn-icon-split px-2 py-2">
                                        <span>
                                        <i class="fas fa-trash"></i>
                                        <span>Eliminar</span>
                                        </span>
                                    </button>
                                    <input type="hidden" name="id" value="<%= odon.getId() %>">
                                </form>
                                </div>
                                <form name="editar" action="/editarOdontologo" method="GET">
                                    <button type="submit" class="btn btn-primary btn-icon-split px-3 py-2">
                                        <span>
                                        <i class="fas fa-pencil-alt"></i>
                                        <span>Editar</span>
                                        </span>
                                    </button>
                                    <input type="hidden" name="id" value="<%= odon.getId() %>">
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>

<%@include file="/views/components/footer.jsp"%>

