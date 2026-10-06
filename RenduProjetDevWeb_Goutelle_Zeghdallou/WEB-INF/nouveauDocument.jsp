<jsp:include page="header.jsp">
	<jsp:param value="nouveau Document" name="titre" />
</jsp:include>


<form action="NouveauDocument" method="post">
	<div>
		<label for="nomDocument">Nom du document</label> <br> <input
			type="text" id="nomDocument" name="nomDocument" required="required"
			placeholder="Nom du document">
	</div>
	<div>
		<label for="isPublic">Public</label> <input type="checkbox"
			id="isPublic" name="isPublic">
	</div>
	<div>
		<label for="lectureSeul">Lecture Seul</label> <input type="checkbox"
			id="lectureSeul" name="lectureSeul">
	</div>
	<div>
		<label for="proteger">Proteger</label> <input type="checkbox"
			id="proteger" name="proteger">
	</div>
	<div>
		<label for="mdp">Mot de passet</label> <br> <input type="text"
			id="mdp" name="mdp" placeholder="Mot de passe">
	</div>

	<button type="submit">Valider</button>

	<a href="ListeMesDocument">Retour</a>
</form>

<script type="text/javascript" src="javaScript/estPublic.js"></script>




<jsp:include page="footer.jsp"></jsp:include>