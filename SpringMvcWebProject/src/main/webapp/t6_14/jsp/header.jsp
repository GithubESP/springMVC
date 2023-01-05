<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Foody - Organic Food Website Template</title>
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
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar Start -->
    <div class="container-fluid fixed-top px-0 wow fadeIn" data-wow-delay="0.1s">
        <div class="top-bar row gx-0 align-items-center d-none d-lg-flex">
            <div class="col-lg-6 px-5 text-start">
                <small style="color:white"><i class="fa fa-map-marker-alt me-2"
                        style="color:white"></i>著作版權為武德宮所有</small>
                <small style="color:white" class="ms-4"><i class="fa fa-envelope me-2"></i>wuder@example.com</small>
            </div>
            <div class="col-lg-6 px-5 text-end">
                <small style="color:white">Follow us:</small>
                <a class="text-body ms-3" href=""><i style="color:white" class="fab fa-facebook-f"></i></a>
                <a class="text-body ms-3" href=""><i style="color:white" class="fab fa-twitter"></i></a>
                <a class="text-body ms-3" href=""><i style="color:white" class="fab fa-linkedin-in"></i></a>
                <a class="text-body ms-3" href=""><i style="color:white" class="fab fa-instagram"></i></a>
            </div>
        </div>

         <nav class="navbar navbar-expand-lg navbar-light py-lg-0 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
            <a href="index.html" class="navbar-brand ms-4 ms-lg-0">
            
                <!-- <h1>北港武德宮</h1> -->
            </a>
            <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse"
                data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto p-4 p-lg-0">
                    <a href="index.html" class="nav-item nav-link active" style="color:white">主頁</a>
                    <a href="about.html" class="nav-item nav-link" style="color:white">關於我們</a>

                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
                            style="color:white">產品</a>
                        <div class="dropdown-menu m-0">
                            <a href="blog.html" class="dropdown-item">開運小物</a>
                            <a href="feature.html" class="dropdown-item">課程購買</a>
                        </div>

                    </div>

                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
                            style="color:white">其他功能導覽</a>
                        <div class="dropdown-menu m-0">
                            <a href="blog.html" class="dropdown-item">會員中心</a>
                            <a href="feature.html" class="dropdown-item">訂房資訊</a>
                            <a href="testimonial.html" class="dropdown-item">論壇貼文</a>
                            <a href="/TempleActives/showAllActiveController" class="dropdown-item">活動導覽</a>
                            <a href="404.html" class="dropdown-item">月老牽線</a>

                        </div>
                    </div>
                    <a href="contact.html" class="nav-item nav-link" style="color:white">聯絡我們</a>
                </div>
                <div class="d-none d-lg-flex ms-2">
                    <a class="btn-sm-square bg-white rounded-circle ms-3" href="">
                        <small class="fa fa-search text-body"></small>
                    </a>
                    <a class="btn-sm-square bg-white rounded-circle ms-3" href="">
                        <small class="fa fa-user text-body"></small>
                    </a>
                    <a class="btn-sm-square bg-white rounded-circle ms-3" href="">
                        <small class="fa fa-shopping-bag text-body"></small>
                    </a>
                </div>
            </div>
        </nav>
    </div>
    <!-- Navbar End -->


    <!-- Page Header Start -->
    <div class="container-fluid page-header mb-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container">
            <h1 class="display-3 mb-3 animated slideInDown"></h1>
            <nav aria-label="breadcrumb animated slideInDown">
                <ol class="breadcrumb mb-0">
                    <li class="breadcrumb-item"><a class="text-body" href="#"></a></li>
                    <li class="breadcrumb-item"><a class="text-body" href="#"></a></li>
                    <li class="breadcrumb-item text-dark active" aria-current="page"></li>
                </ol>
            </nav>
        </div>
    </div>
    <!-- Page Header End -->






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