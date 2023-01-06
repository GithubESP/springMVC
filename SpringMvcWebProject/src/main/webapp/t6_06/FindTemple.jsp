<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢</title>
    <style>
        #map {
            height: 600px;
            width: 100%;
        }
    </style>
</head>
<body>
<div align='center'>
<h2>查詢寺廟資料</h2>
 <br>
<hr>
<form:form action='templeFindByIdAction' method="POST" modelAttribute= "temple">
    <table>
         <tr>
             <td align="RIGHT">編號：</td>
             <td align="LEFT"><input type="text" name="templeId" value="1" size="20"></td>
         </tr>
        <tr>
            <td colspan="2" align="center">
            <input type="submit" value="提交" >
            <input    type="button"    name="Button"    value="新增"    
            onClick="location='templeFindByIdAction'">
             </td>
            </tr>
    </table>
</form:form>
<p/>
</div>
</body>
</html>
