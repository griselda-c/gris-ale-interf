<jsp:include page="html/index_a.jsp" />

<%@ page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<LINK rel="stylesheet" href="css/style-tablero.css" type="text/css" media="all">

<jsp:include page="html/index_b.jsp" />


<div id="tablero">

<c:forEach var="jugada" items="${sessionScope.model.zero.opciones}">
<div  class="zero" > <a id="<c:out value="${sessionScope.model.zero.tipoApuesta}"/>-<c:out value="${jugada.valor}"/>" href="Javascript:mostrarJugadas('<c:out value="${sessionScope.model.zero.tipoApuesta}"/>', '<c:out value="${jugada.valor}"/>', '<c:out value="${jugada.valor}"/>')"><c:out value="${jugada.nombre}"/><span class="stitle">Pleno</span></a> </div><!-- cierra Fila-n -->
</c:forEach>

<c:forEach var="jugada" items="${sessionScope.model.columna.opciones}">
<div  class="columna" > <a id="<c:out value="${sessionScope.model.columna.tipoApuesta}"/>-<c:out value="${jugada.valor}"/>" href="Javascript:mostrarJugadas('<c:out value="${sessionScope.model.columna.tipoApuesta}"/>', '<c:out value="${jugada.valor}"/>', '<c:out value="${jugada.nombre}"/>')"><c:out value="${jugada.valor}"/><span class="stitle">Columna</span></a> </div><!-- cierra Fila-1 -->
</c:forEach>


<div class="filas_frame">
<c:forEach var="jugada" items="${sessionScope.model.fila.opciones}">
<div class="fila" > <a id="<c:out value="${sessionScope.model.fila.tipoApuesta}"/>-<c:out value="${jugada.valor}"/>" href="Javascript:mostrarJugadas('<c:out value="${sessionScope.model.fila.tipoApuesta}"/>', '<c:out value="${jugada.valor}"/>', '<c:out value="${jugada.nombre}"/>')"><c:out value="${jugada.valor}"/><span class="stitle">Fila</span></a> </div><!-- cierra Fila-n -->
</c:forEach>
</div><!-- cierra .filas_frame -->


<div class="plenos_frame">

<c:forEach var="jugada" items="${sessionScope.model.pleno.opciones}">
<div class="<c:out value="${jugada.clase}"/>" ><a id="<c:out value="${sessionScope.model.pleno.tipoApuesta}"/>-<c:out value="${jugada.valor}"/>" href="Javascript:mostrarJugadas('<c:out value="${sessionScope.model.pleno.tipoApuesta}"/>', '<c:out value="${jugada.valor}"/>', '<c:out value="${jugada.nombre}"/>')"><c:out value="${jugada.valor}"/><span class="stitle">Pleno</span></a> </div><!-- cierra Fila-n -->
</c:forEach>


</div><!-- cierra .plenos_frame -->

<c:forEach var="jugada" items="${sessionScope.model.paridad.opciones}">
<div  class="paridad" > <a id="<c:out value="${sessionScope.model.paridad.tipoApuesta}"/>-<c:out value="${jugada.valor}"/>" href="Javascript:mostrarJugadas('<c:out value="${sessionScope.model.paridad.tipoApuesta}"/>', '<c:out value="${jugada.valor}"/>', '<c:out value="${jugada.nombre}"/>')"><c:out value="${jugada.nombre}"/></a> </div><!-- cierra Fila-n -->
</c:forEach>





<div id="fix-tablero" style="clear:both;"></div><!-- cierra fix-tablero -->

  
</div><!-- cierra tablero -->

<jsp:include page="html/index_c.jsp" />