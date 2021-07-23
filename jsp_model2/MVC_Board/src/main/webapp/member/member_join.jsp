<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

var checkIdResult = false, checkPasswordResult = false, checkPasswordConfirmResult = false;

function checkId(id){
	
// 	var regex = new RegExp('^[A-Za-z0-9]{4,12}$');
	var regex = /^[A-Za-z0-9]{4,12}$/;
	
	var element = document.getElementById('checkIdResult');
	if(regex.exec(id)) {
		element.innerHTML = '사용 가능';
		checkIdResult = true;
	} else {
		element.innerHTML = '사용 불가능';
		checkIdResult = false;
	}
	
}
function checkPassword(password){
	
	var lengthRegex = /^[A-Za-z0-9!@#$%]{8,16}$/;
	var engUpperCaseRegex = /[A-Z]/;
	var engLowerCaseRegex = /[a-z]/;
	var digitRegex = /[0-9]/;
	var specRegex = /[!@#$%]/;
	
	var element = document.getElementById('checkPasswordResult');
	if(lengthRegex.exec(password)) {
		var safetyCount = 0;
		if(engUpperCaseRegex.exec(password)) {
			safetyCount++;
		}
		if(engLowerCaseRegex.exec(password)) {
			safetyCount++;
		}
		if(digitRegex.exec(password)) {
			safetyCount++;
		}
		if(specRegex.exec(password)) {
			safetyCount++;
		}
		
		switch(safetyCount) {
			case 1: 
				element.innerHTML = '사용 불가'; 
				element.style.color = '#black';
				checkPasswordResult = false;
				break;
			case 2: 
				element.innerHTML = '위험'; 
				element.style.color = 'red';
				checkPasswordResult = true;
				break;
			case 3: 
				element.innerHTML = '보통';
				element.style.color = 'orange';
				checkPasswordResult = true;
				break;
			case 4:
				element.innerHTML = '안전'; 
				element.style.color = 'green';
				checkPasswordResult = true;
				break;
		}
		
	} else {
		element.innerHTML = '사용 불가능';		
		element.style.color = '#black';
		checkPasswordResult = false;
	}
	
}
function checkPasswordConfirm(password) {
	var element = document.getElementById('passwordConfirmResult');
	if(password == document.joinForm.password.value) {
		element.innerHTML = '패스워드 일치';
		checkPasswordConfirmResult = true;
	} else {
		element.innerHTML = '패스워드 불일치';
		checkPasswordConfirmResult = false;
	}
}

function checkForm() {
	if(checkIdResult && checkPasswordResult && checkPasswordConfirmResult){
		return true;
	} else {
		alert('입력 항목을 확인하세요');
		return false;
	}
}

function domainSelect(domain) {
	document.joinForm.email2.value = domain;
}

</script>
</head>
<body>
   <h1>회원 가입</h1>
   <form action="MemberJoinPro.me" method="post" name="joinForm" onsubmit="return checkForm()">
      <table border="1">
         <tr>
            <td>이름</td>
            <td><input type="text" name="name" required="required" size="20"></td>
         </tr>
         <tr>
            <td>아이디</td>
            <td>
               <input type="text" name="id" required="required" size="20" placeholder="4~12자리 영문자 + 숫자" onkeyup="checkId(this.value)">
               <span id="checkIdResult"></span>
            </td>
         </tr>
         <tr>
            <td>패스워드</td>
            <td>
               <input type="password" name="password" required="required" size="20" placeholder="8~16자리 영문자 + 숫자 + 특수문자"  onkeyup="checkPassword(this.value)">
               <span id="checkPasswordResult"></span>
            </td>
         </tr>
         <tr>
            <td>패스워드확인</td>
            <td>
               <input type="password" name="passwordConfirm" size="20" onkeyup="checkPasswordConfirm(this.value)">
               <span id="passwordConfirmResult"></span>
            </td>
         </tr>
         <tr>
            <td>E-Mail</td>
            <td>
               <input type="text" name="email1" required="required" size="10">@
               <input type="text" name="email2" required="required" size="10">
               <select name="selectDomain" onchange="domainSelect(this.value)">
                  <option value="">직접입력</option>   
                  <option value="naver.com">naver.com</option>
                  <option value="nate.com">nate.com</option>
               </select>
            </td>
         </tr>
         <tr>
            <td colspan="2" align="center">
               <input type="submit" value="회원가입">
               <input type="button" value="취소" onclick="history.back()">
            </td>
         </tr>
      </table>
   </form>
</body>
</html>