<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="header.jsp">
	<jsp:param value="Connection" name="titre" />
</jsp:include>

<h2>Connexion</h2>
<div class="formulaire">
	<c:if test="${erreurLogin == 'vrai' }">
		<div class="erreur">Pseudo ou mot de passe incorecte</div>
	</c:if>
	<form action="Connection" method="post">
		<div>
			<input type="text" id="pseudo" name="pseudo" required="required"
				placeholder="Votre pseudo">
		</div>

		<div>
			<input type="password" id="mdp" name="mdp" required="required"
				placeholder="Mot de passe">
		</div>

		<button class="valider" type="submit">Valider</button>

	</form>

	<form action="index" method="get">
		<button type="submit">Retour</button>
	</form>

</div>

<jsp:include page="footer.jsp"></jsp:include>