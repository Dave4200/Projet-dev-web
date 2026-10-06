let btn = document.getElementById('changeMdp');
let div  =  document.getElementById('divChangeMdp');

btn.addEventListener("click",( ) => {
	if(getComputedStyle(div).display != "none"){
	    div.style.display = "none";
	  } else {
	    div.style.display = "block";
	  }
})

	    div.style.display = "none";
