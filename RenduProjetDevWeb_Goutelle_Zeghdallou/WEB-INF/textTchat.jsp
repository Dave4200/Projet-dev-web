<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp">
	<jsp:param value="text tchat" name="titre" />
</jsp:include>

<% 
   response.setHeader("Refresh", "1"); 
%>

<c:if test="${ utilisateur.document.listMessage != null}">

	<c:forEach items="${ utilisateur.document.listMessage }" var="list">
	<p>[${list.date}] ${ list.pseudo} : ${ list.texte }</p>
	</c:forEach>


</c:if>

<jsp:include page="footer.jsp"></jsp:include>