
window.addEventListener("load", function(){
	let section = document.querySelector("section2");
	let statusSelect = document.getElementById("status-select"); 
	let statusInput = document.getElementById("status-input");
//	let changeButton = section.querySelector(".change-button");
	let changeButton = document.getElementById('text');
	
	changeButton.onclick = function(){
		alert("변경이 완료 되었습니다");
		statusInput.value = statusSelect.value;
		document.getElementById("demo").innerHTML = "변경 완료";
		console.log(statusInput.value);
	}
})
