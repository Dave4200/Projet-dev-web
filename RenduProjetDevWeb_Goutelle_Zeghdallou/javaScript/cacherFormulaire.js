let btn = document.getElementById('btn');
let div  =  document.getElementById('div');

btn.addEventListener("click",( ) => {
	if(getComputedStyle(div).display != "none"){
	    div.style.display = "none";
	  } else {
	    div.style.display = "block";
	  }
})

	    div.style.display = "none";