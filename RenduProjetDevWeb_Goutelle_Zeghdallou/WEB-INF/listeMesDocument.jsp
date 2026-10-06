<%@page import="serveur.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp">
	<jsp:param value="liste Mes Document" name="titre" />
</jsp:include>


<a href="NouveauDocument">Nouveau Document</a>


<h3 id="mesDoc">Mes Documents</h3>

<div id="mesDocDiv">
	<c:if test="${  utilisateur.listeDocument != null  }">
		<c:forEach items="${ utilisateur.listeDocument }" var="list">

			<c:if test="${utilisateur.idPseudo == list.createur }">
				<form action="Document" method="post" target="centre">
					<input type="text" name="nomDocu" id="nomDocu" value="${list.nom }" hidden="true">
						
				 <input type="text" name="nomCrea"
						id="nomCrea" value="${list.createur }" hidden="true">
			<input type="text" name="isPublic" id="isPublic" value=${list.isPublic } hidden="true">
					<button class="valider" type="submit">${list.nom }</button>
				</form>
			</c:if>
		</c:forEach>
	</c:if>
</div>



<h3 id="docPar">Document Partager</h3>
<div id="docParDiv">
	<c:if test="${  utilisateur.listeDocument != null  }">
		<c:forEach items="${ utilisateur.listeDocument }" var="list">
			<c:if test="${utilisateur.idPseudo != list.createur && list.isPublic == false }">
				<form action="Document" method="post" target="centre">
					<input type="text" name="nomDocu" id="nomDocu" value="${list.nom }"
						hidden="true">
						 <input type="text" name="nomCrea"
						id="nomCrea" value="${list.createur }" hidden="true">
					<input type="text" name="isPublic" id="isPublic" value=${list.isPublic } hidden="true">

					<button class="valider" type="submit">${list.nom }</button>
				</form>
			</c:if>
		</c:forEach>
	</c:if>
</div>

<h3 id="docPub">Document Public</h3>
<div id="docPubDiv">
	<c:if test="${  utilisateur.listeDocument != null  }">
		<c:forEach items="${ utilisateur.listeDocument }" var="list">
			<c:if test="${utilisateur.idPseudo != list.createur && list.isPublic == true }">
				<form action="Document" method="post" target="centre">
					<input type="text" name="nomDocu" id="nomDocu" value="${list.nom }"	hidden="true"> 
					<input type="text" name="nomCrea" id="nomCrea" value="${list.createur }" hidden="true">
					<input type="text" name="isPublic" id="isPublic" value=${list.isPublic } hidden="true">
					<button class="valider" type="submit">${list.nom }</button>
				</form>
			</c:if>
		</c:forEach>
	</c:if>

</div>

<script type="text/javascript" src="javaScript/menuDeroulant.js"></script>
<jsp:include page="footer.jsp"></jsp:include>