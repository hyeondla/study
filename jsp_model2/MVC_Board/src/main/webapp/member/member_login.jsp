<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #loginFormArea {
      margin: auto;
      width: 350px;
      height: 200px;
      border: 2px double purple;
      border-radius: 10px;
      text-align: center;
   }
   
   fieldset {
      text-align: center;
      border: none;
   }
   
   #selectButton {
      margin-top: 10px;
   }
   
   table {
      width: 300px;
      margin: auto;
   }
   
   .td_left {
      width: 180px;
   }
   
   .td_right {
      width: 200px;
   }
</style>
</head>
<body>
   <section id="loginFormArea">
      <h1>로그인</h1>
      <form action="MemberLoginPro.me" method="post" name="loginForm">
         <fieldset>
            <table>
               <tr>
                  <td class="td_left">
                     <label for="id">아이디</label>
                  </td>
                  <td class="td_right">
                     <input type="text" name="id">
                  </td>
               </tr>
               <tr>
                  <td class="td_left">
                     <label for="id">패스워드</label>
                  </td>
                  <td class="td_right">
                     <input type="password" name="password">
                  </td>
               </tr>
            </table>
            <br>
            <input type="submit" value="로그인">
            <input type="button" value="회원가입" onclick="location.href='MemberJoinForm.me'">
            <input type="button" value="취소" onclick="history.back()">
         </fieldset>
      </form>
   </section>
</body>
</html>
