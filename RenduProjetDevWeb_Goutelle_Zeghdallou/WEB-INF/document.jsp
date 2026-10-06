<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp">
	<jsp:param value="Doument" name="titre" />
</jsp:include>


<c:if test="${utilisateur.document != null }">

<div class="partageDoc">
	<h2>${utilisateur.document.nom}</h2>
	<c:if test="${utilisateur.idPseudo == utilisateur.document.createur }">
		<button id="btn">Partager</button>
		<div id="div">
			<form action="PartagerDocument" method="post">
				<label for="pseudoPartage">Pseudo de l'utilisateur </label>
				<input type="text" id="pseudoPartage" name="pseudoPartage">
				<label for="lectureSeul">Lecture seul</label>
				<input type="checkbox"	id="lectureSeul" name="lectureSeul">
				<button type="submit">Partager</button>
			</form>
		</div>
	</c:if>
</div>


<form id="modif">
	<textarea id="texteDocument" name="texteDocument" cols="100" rows="100"	
	form="modif">${utilisateur.document.texte}</textarea>
</form>

<script type="text/javascript" src="javaScript/cacherFormulaire.js"></script>
<script type="text/javascript" src="javaScript/scynchroDoc.js"></script>
</c:if>

<jsp:include page="footer.jsp"></jsp:include>