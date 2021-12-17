<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
<jsp:include page="../partials/dataTable.jsp"></jsp:include>



</head>


<body>
	<jsp:include page="../partials/nav.jsp"></jsp:include>
	
	

	<div class="col-lg-6 mx-auto py-md-3">
	<c:if test="${user.isAdmin()}"><div ><a href="crearAtr.do"
										class="btn btn-warning rounded" role="button" title= "Agregar atracci�n"> <i
										class="bi bi-plus-lg" style="font-size: 1.3rem; color: white;"></i></a></div> <br></c:if>
		<table id="dataTable" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atraccionesUser}" var="attraction">
					<tr>
						<td><strong><c:out value="${attraction.nombre}"></c:out></strong>
							<p>
								Esta es una atracci�n de
								<c:out value="${attraction.tipo}"></c:out>
							</p></td>
						<td><c:out value="${attraction.costo}"></c:out></td>
						<td><c:out value="${attraction.tiempoPromedio}"></c:out></td>
						<td><c:out value="${attraction.cupo}"></c:out></td>

						<td><c:if test="${user.isAdmin()}">
								<a href="editAtr.do?id=${attraction.id}"
									class="btn btn-info rounded" role="button" title= "Editar"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="deleteAtr.do?id=${attraction.id}"
									class="btn btn-danger rounded" role="button" title= "Eliminar"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if> <c:choose>

								<c:when
									test="${user.puedePagar(attraction) && user.tieneTiempo(attraction) && attraction.hayCupo() && !user.itinerarioContiene(attraction)}">
									<a href="comprarAtr.do?id=${attraction.id}"
										class="btn btn-success rounded" role="button" title= "Comprar"> <i
										class="bi bi-cart3"></i></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button"><i class="bi bi-cart3"></i></a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	

    
    
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>
