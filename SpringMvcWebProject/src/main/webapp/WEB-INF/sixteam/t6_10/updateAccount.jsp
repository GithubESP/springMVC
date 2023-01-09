<%@ page import="sixteam.t6_10.model.*"%>
<%@page import="java.util.List"%>
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
    <title>修改帳號資訊頁面</title>
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
        <h1 class="fa-solid fa-users">修改帳號資訊</h1>
    </header>
    
    <form action=<c:url value='/t6_10_doUpdateAccount.controller' /> enctype = 'multipart/form-data' method='post'>
    <table id="table_id" class="display">
        <thead>
            <tr>
                <th><span class="fa-solid fa-address-card">會員編號</span></th>
                <th><span class="fa-solid fa-circle-user">會員帳號</span></th>
          		<th><span class="fa-solid fa-key">會員密碼</span></th>
                <th><span class="fa-solid fa-image">會員圖片</span></th>
                                <th><span class="fa-solid fa-image">修改會員圖片</span></th>
            </tr>
        </thead>
        <tbody>
                <tr>
                	
                    <td>ID:<input type='text' name='id' readonly="readonly" value="${account.id}"/></td>
                    <td>帳號:<input type='text' name='account' value="${account.account}"/></td>
                    <td>密碼:<input type="password" name="password"  style="border:0px;background:rgba(0, 0, 0, 0);text-align:center;"  value="${account.password}"></td>
                    <td>
                    <img height='100' width='80' src="<c:url value='/t6_10_img.controller/${account.id}' />">
					</td>
                    <td>
                    <input type='file' name='photo' />
                    </td>
                </tr>
				<input style="position: absolute; right: 3%; bottom:50%" type='submit' value='修改'/>
        </tbody>
    </table>
    </form>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () { $('#table_id').DataTable(); });
    </script>
</body>

</html>