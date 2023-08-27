<%@page import="logica.Paciente"%>
<%@page import="java.util.List"%>
<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
    <p class="mb-4">Este es el apartado para visualizar a los pacientes del sistema.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th>Obra social</th>
                            <th>Tipo de Sangre</th>
                            <th style="width: 25%">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th>Obra social</th>
                            <th>Tipo de Sangre</th>
                            <th style="width: 25%">Acción</th>
                        </tr>
                    </tfoot>
                    <% List<Paciente> lista = (List) request.getSession().getAttribute("listaPacientes");%> 
                    
                    <tbody>
                        <%for (Paciente pacien : lista){ %>
                        <tr>
                            <td id= "ide_us <%= pacien.getId() %>"><%= pacien.getId() %></td>
                             <td><%= pacien.getNombre() %></td>
                            <td><%= pacien.getApellido() %></td>
                            <td><%= pacien.getDni()%></td>
                            <td><%= pacien.getDireccion() %></td>
                            <td><%= pacien.getTelefono() %></td>
                            <td><%= pacien.isTiene_os() %></td>
                            <td><%= pacien.getTipoSangre() %></td>
                            <td style=" display: flex;">
                                <div class="me-5">
                                <form name="eliminar" action="/eliminarPaciente" method="POST" style="margin-right: 1rem">
                                    <button type="submit" class="btn btn-danger btn-icon-split px-2 py-2">
                                        <span>
                                        <i class="fas fa-trash"></i>
                                        <span>Eliminar</span>
                                        </span>
                                    </button>
                                    <input type="hidden" name="id" value="<%= pacien.getId() %>">
                                </form>
                                </div>
                                <form name="editar" action="/editarPaciente" method="GET">
                                    <button type="submit" class="btn btn-primary btn-icon-split px-3 py-2">
                                        <span>
                                        <i class="fas fa-pencil-alt"></i>
                                        <span>Editar</span>
                                        </span>
                                    </button>
                                    <input type="hidden" name="id" value="<%= pacien.getId() %>">
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

