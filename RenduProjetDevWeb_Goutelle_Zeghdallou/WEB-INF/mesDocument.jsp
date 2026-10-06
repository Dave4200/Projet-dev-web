<jsp:include page="header.jsp">
	<jsp:param value="Mes document" name="titre" />
</jsp:include>

<jsp:include page="menu.jsp"></jsp:include>


<div class="listedocument" >
	<iframe name="gauche" src="ListeMesDocument" width="250px" height="600px" ></iframe>
</div>
<div class="document">
	<iframe id="iframeDoc" name="centre" src="Document" width="800px" height="600px"></iframe>
</div>
<div class="tchat">
	<iframe name="bas" src="Tchat" width="400px" height="400px"></iframe>
</div>




<jsp:include page="footer.jsp"></jsp:include>