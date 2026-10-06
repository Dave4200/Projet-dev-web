<jsp:include page="header.jsp">
	<jsp:param value="liste Mes Document" name="titre" />
</jsp:include>


<form action="EnvoyerMessage" method="post" id="form" target="haut">
	<input type="text" id="mesg" name="msg" >
	<button class="tchat" id="envoyer" type="submit">Envoyer</button>
</form>
<script type="text/javascript" src="javaScript/nettoyerTchat.js"></script>


<jsp:include page="footer.jsp"></jsp:include>