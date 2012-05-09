<jsp:include page="html/index_a.jsp" />

<%@ page isELIgnored ="false" %>


<LINK rel="stylesheet" href="css/style-tablero.css" type="text/css" media="all">

<jsp:include page="html/index_b.jsp" />


<%
if (request.getSession().getAttribute("mostrarapuesta") != null) {
// abro%>${sessionScope.mostrarapuesta}<%
}%>









<jsp:include page="html/index_c.jsp" />