<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="header.jsp" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>活動頁面</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Lora:wght@600;700&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <style type="text/css">
    
    </style>
</head>

<body>
<!-- Blog Start -->
    <div class="container-xxl py-6">
        <div class="container">
            <div class="section-header text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <h1 class="display-5 mb-3">活動頁面</h1>
                <p>心動不如趕快行動</p>
            </div>
          
          <div class="row g-4"> 
          
            <c:forEach var="active" items="${actives}" varStatus="status">
       
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="${(status.index % 3) * 0.2 + 0.1}s">
                    <img  class="img-thumbnail" src="<c:url  value='/toActiveImage?id=${active.activeID}'/>"  alt="" >
                    <div class="bg-light p-4">
                        <a class="d-block h5 lh-base mb-4" href="">${active.activeName}</a>
                        <div  class="text-muted border-top pt-4">
                            <small class="me-3"><i class="fa fa-user text-primary me-2"></i>${active.activeHost}</small>
                            <small class="me-3"><i class="fa fa-calendar text-primary me-2"></i>${active.activeStartDate}</small>
                        </div>
                    </div>
                </div>
           
            
               
         </c:forEach>
         
            </div> 
            
            </div>
            
            </div>
            
            
            
            
            





    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>
<%@ include file="footer.jsp" %>