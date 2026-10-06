let textarea = document.getElementById("texteDocument")
let formDoc = document.getElementById("modif")

textarea.addEventListener("input",( ) => { 
	envoieTexte()
  })
	
	
async function recupTexte(){
	let rq = await fetch('/ProjetDevWeb/EcrireDocument')
	let res =  await rq.text()
	textarea.value= res
}

async function envoieTexte(){
	
	const data = "texteDocument="+ textarea.value	
	const options = {
			method: 'POST', 
			 headers: {
			      "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
				  },
			body: data
			}
	
	let rq =  fetch('/ProjetDevWeb/EcrireDocument',options)
	console.log(rq.body)
}


recupTexte()
setInterval(recupTexte,1000)










/*
 * let requeteXML = new XMLHttpRequest();
 * 
 * 
 * requeteXML.open("POST", "Document", true); requeteXML.send();
 */






/*
 * var texte = document.getElementById('texteDocument') console.log("texte
 * "+texte) var formulaire = document.getElementById('modif'); var indice
 * console.log("formulaire "+formulaire)
 * 
 * texte.focus() texte.setSelectionRange( indice, indice )
 * 
 * texte.addEventListener("input",( ) => { console.log("Je vien taper sur une
 * touche") console.log(texte.selectionStart) indice = texte.selectionStart
 * formulaire.submit()
 *  })
 */



