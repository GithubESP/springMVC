<%@page import="sixteam.t6_21.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>後臺管理系統</title>
        <link href="../background_index/css/index_backgroundOnly.css" rel="stylesheet" />
        
        <link href="../background_index/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
    <div>
    	<jsp:include page="/background_index/index-backToMVC.jsp" /></div>
		


            <div id="layoutSidenav_content" style="margin-left: 250px">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4" style=" text-align:center">課程總覽</h1>
                        <ol class="breadcrumb mb-4">
<!--                             <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li> -->
<!--                             <li class="breadcrumb-item active">Tables</li> -->
                        </ol>
<!--                         <div class="card mb-4"> -->
<!--                             <div class="card-body"> -->
<!--                                 DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the -->
<!--                                 <a target="_blank" href="https://datatables.net/">official DataTables documentation</a> -->
<!--                                 . -->
<!--                             </div> -->
<!--                         </div> -->
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
<!--                                 DataTable Example -->
                            </div>
                            <div class="card-body">
	<form action="<c:url value='/updateClass.controller'/>" method="post"
		enctype="multipart/form-data">
                                <table id="datatablesSimple">
								<thead>
									<tr>
										<th>課程編號</th>
										<th>課程名稱</th>
										<th>課程圖片</th>
										<th>課程老師</th>
										<th>購物車</th>
									</tr>
								</thead>
								<tbody>
									<tr>

										<th><input type="text"  name="classId" value="${bean.classId}" readonly/></th>
										<td><input type="text" name="className" value="${bean.className}"/></td>
										<td><input type="file" name="classPicture1" value="${bean.classPicture1}"/></td>
										<td><input type="text" name="classTeacherName" value="${bean.classTeacherName}"/></td>


										<td>
										    <input type="submit" value="確認"/></td>

									</tr>
								</tbody>
							</table>
						</form>
						</div>
					</div>
				</div>
			</main>
		</div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../background_index/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../background_index/assets/demo/chart-area-demo.js"></script>
        <script src="../background_index/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../background_index/js/datatables-simple-demo.js"></script>


</body>
</html>