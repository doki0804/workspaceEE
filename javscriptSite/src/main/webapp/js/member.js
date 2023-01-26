/**
 * member.js
 */



function join_form_validation_submit_button() {

	let f = document.getElementById('joinForm');
	if (!f.id.value || f.id.value === '') {
		alert('아이디를 입력하세요');
		f.id.focus();
		return false;
	}
	if (!f.password.value || f.password.value === '') {
		alert('패스워드를 입력하세요');
		f.password.focus();
		return false;
	}
	if (!f.repassword.value || f.repassword.value === '') {
		alert('패스워드를 입력하세요');
		f.repassword.focus();
		return false;
	}
	if (!f.name.value || f.name.value === '') {
		alert('이름을 입력하세요');
		f.name.focus();
		return false;
	}
	if (!f.address.value || f.address.value === '') {
		alert('주소를 입력하세요');
		f.address.focus();
		return false;
	}
	if (!isSame(f.password.value,f.repassword.value)) {
		alert('패스워드와 패스워드확인이 일치하지 않습니다.');
		f.repassword.select();
		return false;
	}


	return true;

}
function join_form_validation_button() {

	let f = document.joinForm;
	if (!f.id.value || f.id.value === '') {
		alert('아이디를 입력하세요');
		f.id.focus();
		return;
	}
	if (!f.password.value || f.password.value === '') {
		alert('패스워드를 입력하세요');
		f.password.focus();
		return;
	}
	if (!f.repassword.value || f.repassword.value === '') {
		alert('패스워드를 입력하세요');
		f.repassword.focus();
		return;
	}
	if (!f.name.value || f.name.value === '') {
		alert('이름을 입력하세요');
		f.name.focus();
		return;
	}
	if (!f.address.value || f.address.value === '') {
		alert('주소를 입력하세요');
		f.address.focus();
		return;
	}
	if (!isSame(f.password.value,f.repassword.value)) {
		alert('패스워드와 패스워드확인이 일치하지 않습니다.');
		f.repassword.select();
		return;
	}

	f.method = 'POST';
	f.action = 'login_action.jsp';
	f.submit();
	return;
}	