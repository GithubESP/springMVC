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
        <link href="${pageContext.request.contextPath}/background_index/css/index_backgroundOnly.css" rel="stylesheet" />
        
        <link href="${pageContext.request.contextPath}/background_index/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
    <div>
    	<jsp:include page="/background_index/index-backToMVC.jsp" /></div>
    
            <div id="layoutSidenav_content" style="margin-left: 250px">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4" style=" text-align:center">討論區</h1>
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
                                <table id="datatablesSimple">
		<thead>
			<tr>
				<th>貼文日期</th>
				<th>標題</th>
				<th>內容</th>
				<th>圖片</th>
				<th>推</th>
				<th>噓</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bean" items="${postlist}">
				<tr>
					<td>${bean.postDate}</td>
          <td>${bean.postTitle}</td>
          <td>${bean.postContent}</td>
          <td><img height='100' width='80'src="t6_27img.controller/${bean.picture}"></td>
          <td>${bean.postLike}</td>
          <td>${bean.postDislike}</td>
          <td>${bean.postComment}</td>
     				<td>
					<div style="display:inline">
           <a href="t6_27delete.controller/${bean.postId}"><input type="submit" value="刪除"></a>
           <a href="t6_27updatePage.controller/${bean.postId}"><input type="submit" value="修改"></a>
				</div>
				</tr>
     				
			</c:forEach>
		</tbody>
                                </table>
					<div><form action="t6_27addPage.controller"><input type="submit" value="新增貼文"></form></div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
          
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/background_index/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/background_index/assets/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/background_index/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/background_index/js/datatables-simple-demo.js"></script>
        
        
        
        
        
    </body>
</html>