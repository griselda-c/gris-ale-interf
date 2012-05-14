<jsp:include page="html/index_a.jsp" />

<%@ page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<LINK rel="stylesheet" href="css/style-tablero.css" type="text/css" media="all">

<jsp:include page="html/index_b.jsp" />


<div id="tablero">

<div id="Pleno-0" class="zero" > <a href="#">0<span class="stitle">Pleno</span></a> </div><!-- cierra Pleno-0 -->

<div id="Columna-1" class="columna" > <a href="#">1<br/><span class="stitle">Columna</span></a> </div><!-- cierra Columna-1 -->
<div id="Columna-1" class="columna" > <a href="#">2<br/><span class="stitle">Columna</span></a> </div><!-- cierra Columna-1 -->
<div id="Columna-1" class="columna" > <a href="#">3<br/><span class="stitle">Columna</span></a> </div><!-- cierra Columna-1 -->

<div class="filas_frame">


<%/*
<c:forEach var="apuesta" items="${sessionScope.model.plenoColeccion}">
                        <c:out value="${apuesta.tipoApuesta}"/>
</c:forEach>
*/%>


<div id="Fila-1" class="fila" > <a href="#">1<span class="stitle">Fila</span></a> </div><!-- cierra Fila-1 -->
<div id="Fila-1" class="fila" > <a href="#">2<span class="stitle">Fila</span></a> </div><!-- cierra Fila-1 -->
<div id="Fila-1" class="fila" > <a href="#">3<span class="stitle">Fila</span></a> </div><!-- cierra Fila-1 -->

</div><!-- cierra .filas_frame -->


<div class="plenos_frame">

<div id="Pleno-1" class="rojo" > <a href="#">1<span class="stitle">Pleno</span></a> </div><!-- cierra Pleno-0 -->

<div id="Pleno-2" class="negro" > <a href="#">2<span class="stitle">Pleno</span></a> </div><!-- cierra Pleno-0 -->

<div id="Pleno-2" class="negro" > <a href="#">3<span class="stitle">Pleno</span></a> </div><!-- cierra Pleno-0 -->

</div><!-- cierra .plenos_frame -->


<div id="Paridad-1" class="paridad" > <a href="#">Par</a> </div><!-- cierra Paridad-1 -->

<div id="Paridad-1" class="paridad" > <a href="#">Par</a> </div><!-- cierra Paridad-1 -->




<div id="fix-tablero" style="clear:both;"></div><!-- cierra fix-tablero -->

  
</div><!-- cierra tablero -->

<jsp:include page="html/index_c.jsp" />