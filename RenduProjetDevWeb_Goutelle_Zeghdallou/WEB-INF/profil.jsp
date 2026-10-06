<jsp:include page="header.jsp">
	<jsp:param value="Profile" name="titre" />
</jsp:include>

<jsp:include page="menu.jsp"></jsp:include>
<div class="formulaire">
	<h1>Pseudo : ${ utilisateur.idPseudo }</h1>

	<button id="changeMdp">Changer le mot de passe</button>
	<div id="divChangeMdp">
		<form action="ChangeMdp" method="post">
			<label for="mdp">Mot de passe</label>
			<input type="password" id="mdp"	name="mdp" required="required"><br>
			
			<label for="nouveauMdp">Nouveau mot de passe</label>
			<input type="password" id="nouveauMdp"name="nouveauMdp" required="required"><br>
			<button class="valider" type="submit">Changer le mot de passe</button>
		</form>

	</div>
</div>
<script type="text/javascript" src="javaScript/changeMdp.js"></script>

<jsp:include page="footer.jsp"></jsp:include>