<%@page import="es.altair.bean.Libro"%>
<%@page import="es.altair.dao.LibroDAOImplHibernate"%>
<%@page import="es.altair.dao.LibroDAO"%>
<%@page import="es.altair.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libros del Usuario</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- Stylesheets -->
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
</head>
<body>
	<div class="container">

		<%
			if (session.getAttribute("usuLogeado") == null || session.isNew()) {
				response.sendRedirect("../index.jsp?mensaje=Inicie sesi�n");
			} else {
				LibroDAO lDAO = new LibroDAOImplHibernate();
				Libro l = lDAO.obtetenerLirboPorUUID(request.getParameter("uuid"));
				System.out.println(l);
		%>

		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../index.jsp">Bienvenido
						<%=((Usuario) session.getAttribute("usuLogeado")).getNombre()%>
				</a></li>
				<li class="breadcrumb-item"><a href="principalUsu.jsp">Pincipal
						Usuario</a></li>
				<li class="breadcrumb-item">Editar Libro</li>
				<li class="breadcrumb-item active"><a href="../CerrarSesion">Cerrar
						Sesi�n</a></li>
			</ol>
		</div>

		<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<div class="form-area">
					<form action="../EditarLibro" method="post" role="form"
						enctype="multipart/form-data">
						<h3>Editar Libro</h3>
						<input type="hidden" name="uuid" id="uuid" value="<%=l.getUuid()%>">
						<div class="form-group">
							<label for="titulo">Titulo</label> <input type="text"
								name="titulo" id="titulo" class="form-control"
								value="<%=l.getTitulo()%>">
						</div>
						<div class="form-group">
							<label for="titulo">Autor</label> <input type="text" name="autor"
								id="autor" class="form-control" value="<%=l.getAutor()%>">
						</div>
						<div class="form-group">
							<label for="titulo">ISBN</label> <input type="number" name="isbn"
								id="isbn" class="form-control" value="<%=l.getIsbn()%>">
						</div>
						<div class="form-group">
							<img alt="Portada" src="image.jsp?imag=<%=l.getIdLibro()%>"
								class="img-thumbnail" width="50" height="50"> <input
								type="file" class="form-control" id="portada" name="portada">
						</div>
						<div class="form-group">
							<input type="submit" class="form-control btn btn-primary">
						</div>
					</form>
				</div>
			</div>
		</div>


		<%
			}
		%>



	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>