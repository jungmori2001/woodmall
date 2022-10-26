/**
 * 
 */
window.addEventListener("load", function(){
	let checkDelete = document.getElementById("checkDelete"); 
	let userId = document.getElementById("userId");
	
	checkDelete.onclick=function(){
		if (!confirm("정말로 삭제하시겠습니까?")){
			location.href="memberList.do";
			console.log("트루");
			
		}else{
			location.href="deleteMember.do?userId="+userId.value;
		}
		location.href="memberList.do";
	}
})