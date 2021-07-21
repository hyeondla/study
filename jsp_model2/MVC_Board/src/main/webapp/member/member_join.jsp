<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function selectDomain(selectBox) {
	
}
</script>
</head>
<body>
   <h1>회원 가입</h1>
   <form action="MemberJoinPro.me" method="post" name="joinForm">
      <table border="1">
         <tr>
            <td>이름</td>
            <td><input type="text" name="name" required="required" size="20"></td>
         </tr>
         <tr>
            <td>아이디</td>
            <td>
               <input type="text" name="id" required="required" size="20">
            </td>
         </tr>
         <tr>
            <td>패스워드</td>
            <td>
               <input type="password" name="password" required="required" size="20">
            </td>
         </tr>
         <tr>
            <td>패스워드확인</td>
            <td>
               <input type="password" name="passwordConfirm" size="20">
            </td>
         </tr>
         <tr>
            <td>E-Mail</td>
            <td>
               <input type="text" name="email1" required="required" size="10">@
               <input type="text" name="email2" required="required" size="10">
               <select name="selectDomain" onchange="selectDomain(this)">
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