<%@ page import="java.util.List" %>
<%@ page import="Incidencia" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Estado de incidencias</title>

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
                        <div class="estado-box">DNI</div>
                        <div class="estado-box">Fecha</div>
                        <div class="estado-box">Estado</div>
                    </div>

                    <%
                        java.util.List<Incidencia> incidencias =
                            (java.util.List<Incidencia>) request.getAttribute("incidencias");

                        if (incidencias != null && !incidencias.isEmpty()) {
                            for (Incidencia incidencia : incidencias) {
                    %>

                    <div class="estado-row">
                        <div class="estado-box"><%= incidencia.getDni() %></div>
                        <div class="estado-box"><%= incidencia.getFecha() %></div>
                        <div class="estado-box"><%= incidencia.getEstado() %></div>
                    </div>

                    <%
                             }
                        } else {
                    %>

                    <div class="estado-row">
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
            <a href="index.html" class="btn-salir">SALIR</a>
            </div>
    </main>

</body>
</html>