let champ = document.getElementById("mesg")
let btn  =  document.getElementById("form")

btn.addEventListener("submit",( ) => {
	supp()
})


 function sleep(ms) {
      return new Promise(resolve => setTimeout(resolve, ms));
   }

async function supp (){
await sleep(100)
champ.value = ""
}