<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="header.jsp">
	<jsp:param value="Inscription" name="titre" />

</jsp:include>

<h2>Inscription</h2>

<div class="formulaire">
	<c:if test="${erreurInscription == 'vrai' }">
		<div class="erreur">Pseudo deja utiliser</div>
	</c:if>

	<form action="Inscription" method="post">
		<div>
			<label for="pseudo">Pseudo :</label> <br> <input type="text"
				id="pseudo" name="pseudo" required="required"
				placeholder="Votre pseudo">
		</div>

		<div>
			<label for="mdp">Mot de passe :</label> <br> <input
				type="password" id="mdp" name="mdp" required="required"
				placeholder="Mot de passe">
		</div>
		<button type="submit">Valider</button>
	</form>


	<form action="index" method="get">
		<button type="submit">Retour</button>
	</form>

</div>
<jsp:include page="footer.jsp"></jsp:include>

