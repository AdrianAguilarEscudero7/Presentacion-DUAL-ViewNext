<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">

<html>
<head>
	<meta charset="UTF-8">
	<title>Configuración</title>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<header>
    	<nav class="navbar navbar-default">
        	<div class="container-fluid">
          		<div class="navbar-header">
          			<span class="navbar-brand">Sneak</span>
          		</div>
          		<ul class="nav navbar-nav">
					<li><a href="index">INICIO</a></li>
            		<li><a id="go-config" class="inConfig" href="config">CONFIGURACIÓN</a></li>
          		</ul>
      		</div>
    	</nav>
    </header><br>
	<section>
		<div class="section-main">
        	<div class="sub-section">
        		<span id="config-select-title">Responsables</span>
        		<div id="config-content">
					<form id="config-form" method="post" action="select">
						<select id="config-select" size="10" name="respSelected">
							<%
								Class.forName("com.mysql.cj.jdbc.Driver");
								String url = "jdbc:mysql://localhost:3306/sneak?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
								Connection conex = null;
								conex = DriverManager.getConnection(url,"root","");
								ResultSet rs = conex.createStatement().executeQuery("SELECT * FROM snk_conf WHERE clave= 'responsable'");
								
								while (rs.next()) {
									out.println("<option>"+rs.getString(3)+"</option>");
								}
								
								conex.close(); // Conexión cerrada
							%>
						</select><br>
						<div id="config-subContent">
							<input id="insert-resp-input" type="text" name="responsable" placeholder="Introduzca un responsable." maxlength="50" autofocus>
							<input type="submit" id="add-resp" class="btn-config-section" name="add" value="AÑADIR">
							<input type="submit" id="delete-resp" class="btn-config-section" value="ELIMINAR">
							<script>
								$("#delete-resp").click(function() {		
									if(confirm("¿Segur@ que desea llevar a cabo el borrado?")) {
										$("#delete-resp").attr("name","delete");
									} else {
										$("#delete-resp").attr("name","notSure");
									}
								});
							</script>
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:set var="showMsg" value="${configuracion.msg}"/>
		<c:choose>
			<c:when test="${showMsg == 'El responsable introducido ya existe.'}">
		    	<script>alert("${showMsg}")</script>
		    </c:when>
		    <c:when test="${showMsg == 'No ha introducido ningún responsable.'}">
		  		<script>alert("${showMsg}")</script>
		    </c:when>
		    <c:when test="${showMsg == 'No ha seleccionado ningún responsable.'}">
		    	<script>alert("${showMsg}")</script>
		    </c:when>
		</c:choose>
	</section>
</body>
</html>
