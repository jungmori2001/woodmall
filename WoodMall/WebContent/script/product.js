/**
 * 
 */
function checkProduct(){
	if(document.frm.name.value.length===0){
		alert("상품명을 입력하세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.price.value.length===0){
		alert("상품의 가격을 입력하세요.");
		frm.name.focus();
		return false;
	}
	return true;
	
}