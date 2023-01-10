<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者登入系統</title>
</head>
<body>
<h3>管理者登入系統</h3>
<form action="checklogin.controller" method="post">
    <table>
       <tr>
          <td>帳號:</td>
          <td><input type="text" name="userName"/></td>
          <td>${errors.name}</td>
       </tr>
       <tr>
          <td>密碼:</td>
          <td><input type="password" name="userPwd"/></td>
          <td>${errors.pwd}</td>
       </tr>
       <tr>
          <td><button type="submit" value="login">送出</button></td>
          <td>${errors.msg}</td>
       </tr>
    </table>
</form>
</body>
</html>