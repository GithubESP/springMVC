<%@ page import="sixteam.t6_10.model.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查詢頁面</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://kit.fontawesome.com/89b068a769.js" crossorigin="anonymous"></script>
    <style>
        table {
            text-align: center;
        }
    </style>
</head>

<body>
<%--     <jsp:include page="/fragment/topMVC.jsp" /> --%>
    <header>
        <h1 class="fa-solid fa-users">查詢所有會員</h1><a style="position: absolute; right: 0;" class="fa-solid fa-user-plus" href="t6_10_toAddAccount.controller/${accounts.get(accounts.size()-1).getId()+1}">新增</a> 
<a style="position: relative; right: 15;" class="fa-solid fa-house" href="http://localhost:8080/SpringMvcWebProject/">首頁</a>
    </header>
    <table id="table_id" class="display">
        <thead>
            <tr>
                <th><span class="fa-solid fa-address-card">會員編號</span></th>
                <th><span class="fa-solid fa-circle-user">會員姓名</span></th>
          		<th><span class="fa-solid fa-key">會員密碼</span></th>
                <th><span class="fa-solid fa-image">會員圖片</span></th>
                <th><span class="fa-solid fa-pen-to-square">操作</span></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bean" items="${accounts}">
                <tr>
                    <td>${bean.id}</td>
                    <td>${bean.account}</td>
                    <td><input type="password" name="password"  style="border:0px;background:rgba(0, 0, 0, 0);text-align:center;"  value="${bean.password}" disabled="disabled"></td>
                    <td><img height='100' width='80' src="<c:url value='/t6_10_img.controller/${bean.id}' />">
                    </td>
                    <td><a class="fa-solid fa-screwdriver-wrench" href=t6_10_toUpdateAccount.controller/${bean.id}>修改</a>&nbsp
                    <a class="fa-solid fa-trash-can" href=t6_10_delAccount.controller/${bean.id}>刪除</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () { $('#table_id').DataTable(); });
    </script>
</body>

</html>