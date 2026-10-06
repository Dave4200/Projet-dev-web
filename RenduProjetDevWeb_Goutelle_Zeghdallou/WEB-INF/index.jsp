<jsp:include page="header.jsp">
	<jsp:param value="Bienvenue" name="titre" />
</jsp:include>

<h2>Bienvenue</h2>
<div class="formulaire">

	<form action="Connection" method="get">
		<button type="submit">Connection</button>
	</form>

	<form action="Inscription" method="get">
		<button type="submit">Inscription</button>
	</form>


</div>

<jsp:include page="footer.jsp"></jsp:include>