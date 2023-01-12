<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<script src="https://kit.fontawesome.com/e136b47e13.js" crossorigin="anonymous"></script>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>後臺管理系統</title>
<link href="../background_index/css/index_backgroundOnly.css"
	rel="stylesheet" />

<link href="../background_index/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">

		<jsp:include page="/background_index/index-backToMVC.jsp" /></div>
            <div id="layoutSidenav_content" style="margin-left: 250px">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Tables</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                            <li class="breadcrumb-item active">Tables</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                                <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
									<tr>
										<th>編號</th>
										<th>寺廟名稱</th>
										<th>主祀神</th>
										<th>行政區</th>
										<th>地址</th>
										<th>登記別</th>
										<th>教別</th>
										<th>電話</th>
										<th>負責人</th>
										<th>其他</th>
										<th>X座標</th>
										<th>Y座標</th>
										<th>統一編號</th>
										<th></th>
									</tr>
								</thead>
<!--                                     <tfoot> -->
<!--                                         <tr> -->
<!--                                             <th>Name</th> -->
<!--                                             <th>Position</th> -->
<!--                                             <th>Office</th> -->
<!--                                             <th>Age</th> -->
<!--                                             <th>Start date</th> -->
<!--                                             <th>Salary</th> -->
<!--                                         </tr> -->
<!--                                     </tfoot> -->
                                   <tbody>
									<c:forEach var="tmp" items="${tmp}">
										<tr>
											<td>${tmp.templeId}<input type="hidden" name="templeId"
												value="${tmp.templeId}"></td>
											<td>${tmp.templeName}<input type="hidden"
												name="templeName" value="${tmp.templeName}"></td>
											<td>${tmp.deitiesName}<input type="hidden"
												name="deitiesName" value="${tmp.deitiesName}"></td>
											<td>${tmp.administrative}<input type="hidden"
												name="administrative" value="${tmp.administrative}"></td>
											<td>${tmp.address}<input type="hidden" name="address"
												value="${tmp.address}"></td>
											<td>${tmp.register}<input type="hidden" name="register"
												value="${tmp.register}"></td>
											<td>${tmp.sect}<input type="hidden" name="sect"
												value="${tmp.sect}"></td>
											<td>${tmp.phone}<input type="hidden" name="phone"
												value="${tmp.phone}"></td>
											<td>${tmp.principal}<input type="hidden"
												name="principal" value="${tmp.principal}"></td>
											<td>${tmp.other}<input type="hidden" name="other"
												value="${tmp.other}"></td>
											<td>${tmp.WGS84X}<input type="hidden" name="wGS84X"
												value="${tmp.WGS84X}"></td>
											<td>${tmp.WGS84Y}<input type="hidden" name="wGS84Y"
												value="${tmp.WGS84Y}"></td>
											<td>${tmp.uniformnumbers}<input type="hidden"
												name="uniformnumbers" value="${tmp.uniformnumbers}"></td>
											<td><a
												href="<c:url value='/templeDeleteAction?templeId=${tmp.templeId}'/>"><input
													type="submit" value="刪除" class="fa-solid fa-trash"></a> <a
												href="<c:url value='/ClassPreUpdateServlet.do?classId=${tmp.templeId}'/>"><input
													type="submit" value="修改"></a>
												<!--	<input type="button" value="刪除" id="${tmp.templeId}"
											class="templeDeleteAction" />-->
													
													</td>
										</tr>
									</c:forEach>
								</tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
            </div>


	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../background_index/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="../background_index/assets/demo/chart-area-demo.js"></script>
	<script src="../background_index/assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="../background_index/js/datatables-simple-demo.js"></script>
	</body>
	
</html>