
let h1 = document.getElementById('mesDoc');
let d1  =  document.getElementById('mesDocDiv');

let h2 = document.getElementById('docPar');
let d2  =  document.getElementById('docParDiv');

let h3 = document.getElementById('docPub');
let d3  =  document.getElementById('docPubDiv');

h1.addEventListener("click",( ) => {
	if(getComputedStyle(d1).display != "none"){
	    d1.style.display = "none";
	  } else {
	    d1.style.display = "block";
	  }
})

h2.addEventListener("click",( ) => {
	if(getComputedStyle(d2).display != "none"){
	    d2.style.display = "none";
	  } else {
	    d2.style.display = "block";
	  }
})

h3.addEventListener("click",( ) => {
	if(getComputedStyle(d3).display != "none"){
	    d3.style.display = "none";
	  } else {
	    d3.style.display = "block";
	  }
})

d1.style.display = "none";
d2.style.display = "none";
d3.style.display = "none";
