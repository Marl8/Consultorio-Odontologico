<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@include file="/views/components/head.jsp"%>

<%@include file="/views/components/barraLateral.jsp"%>

<%@include file="/views/components/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
    <p class="mb-4">Este es el apartado para visualizar a los usuarios del sistema.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre de Usuario</th>
                            <th>Rol</th>
                            <th style="width: 25%">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre de Usuario</th>
                            <th>Rol</th>
                            <th style="width: 25%">Accion</th>
                        </tr>
                    </tfoot>
                    <% List<Usuario> lista = (List) request.getSession().getAttribute("listaUsuarios");%> 
                    
                    <tbody>
                        <%for (Usuario usu : lista){ %>
                        <tr>
                            <td id= "ide_us <%= usu.getId_usuario()%>"><%= usu.getId_usuario()%></td>
                            <td><%= usu.getNombreUsuario() %></td>
                            <td><%= usu.getRol()%></td>
                            <td style=" display: flex;">
                                <div class="me-5">
                                <form name="eliminar" action="eliminarUsuario" method="POST" style="margin-right: 1rem">
                                    <button type="submit" class="btn btn-danger btn-icon-split px-2 py-2">
                                        <span>
                                        <i class="fas fa-trash"></i>
                                        <span>Eliminar</span>
                                        </span>
                                    </button>
                                    <input type="hidden" name="id" value="<%= usu.getId_usuario() %>">
                                </form>
                                </div>
                                <form name="editar" action="editarUsuario" method="GET">
                                    <button type="submit" class="btn btn-primary btn-icon-split px-3 py-2">
                                        <span>
                                        <i class="fas fa-pencil-alt"></i>
                                        <span>Editar</span>
                                        </span>
                                    </button>
                                    <input type="hidden" name="id" value="<%= usu.getId_usuario() %>">
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

