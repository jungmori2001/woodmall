/**
 * 
 */
window.addEventListener("load", function(){
	let checkDelete = document.getElementById("checkDelete"); 
	let userid = document.getElementById("userid");

	console.log(userid.value);
	checkDelete.onclick=function(){
		confirm ("정말로 삭제하시겠습니까?");
		if (checkDelete.value==true){
			console.log("트루");
			alert(userid.value);
//			consol.log(userid.value);
			location.href="deleteMember.do?userid="+userid.value;
		}
		if (checkDelete.value==false){
			console.log("폴스");
			location.href="memberList.do";
		}
		

	}
})