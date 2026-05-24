<%@ page import="java.util.List" %>
<%@ page import="com.gestorincidencias.model.IncidenciaView" %>
<%@ page import="com.gestorincidencias.model.Usuario" %>

<%
    // Recuperar usuario de sesión
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Estado de incidencias</title>
    
    <link rel="icon" type="image/svg+xml" href="assets/img/JJL_logo.svg?v=2">
    <link href="https://fonts.googleapis.com/css2?family=Athiti&family=Alegreya+Sans:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/estilos.css">
</head>

<body>

    <img src="assets/img/JJL_logo.svg" alt="Logo JJL" class="logo-fixed">

    <div class="top-bar">
        <h1>ESTADO DE INCIDENCIAS</h1>
    </div>
        <main class="estado-main">
            <section class="estado-panel">

                <div class="estado-grid">

                    <div class="estado-row estado-header">
                        <div class="estado-box">ID</div>
                        <div class="estado-box">Descripción</div>
                        <div class="estado-box">Fecha</div>
                        <div class="estado-box">Estado</div>
                    </div>
                    
                    <%
                    List<IncidenciaView> incidencias =
                        (List<IncidenciaView>) request.getAttribute("incidencias");

                    if (incidencias != null && !incidencias.isEmpty()) {
                        for (IncidenciaView incidencia : incidencias) {
                            %>

                    <div class="estado-row">
                        <div class="estado-box"><%= incidencia.getId() %></div>
                        <div class="estado-box"><%= incidencia.getDescripcion() %></div>
                        <div class="estado-box"><%= incidencia.getFecha() %></div>
                        <div class="estado-box">

                          <% if (usuario.getRol() == 1) { %>

                            <form action="modificar-estado" method="post">
                                <input type="hidden" name="idIncidencia" value="<%= incidencia.getId() %>">
                                <select name="nuevoEstado" class="estados">
                                    <option value="1" <%= "Pendiente".equals(incidencia.getEstado()) ? "selected" : "" %>>Pendiente</option>
                                    <option value="2" <%= "En proceso".equals(incidencia.getEstado()) ? "selected" : "" %>>En proceso</option>
                                    <option value="3" <%= "Resuelta".equals(incidencia.getEstado()) ? "selected" : "" %>>Resuelta</option>
                                    <option value="4" <%= "Cerrada".equals(incidencia.getEstado()) ? "selected" : "" %>>Cerrada</option>
                                </select>
                                <button type="submit" class="BtnGuardar">Guardar</button>
                            </form>
                            <% } else { %>
                                <%= incidencia.getEstado() %>
                                <% } %>
                        </div>
                    </div>

                    <%
                             }
                        } else {
                    %>

                    <div class="estado-row">
                        <div class="estado-box">Sin datos</div>
                        <div class="estado-box">Sin datos</div>
                        <div class="estado-box">Sin datos</div>
                        <div class="estado-box">Sin datos</div>
                    </div>

                    <%
                        }
                    %>

                </div>
            </section>

            <div class="salir-wrap">
            <a href="incidencias.html" class="btn-salir">VOLVER</a>
            </div>
    </main>

</body>
</html>