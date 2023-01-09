<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="background_index/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
</head>

<body class="bg-primary">
<c:set var="funcName" value="LOG" scope="session"/>
<c:set var="msg" value="登入" />
<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->
   <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />
</c:if>

	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Login</h3>
								</div>
								<div class="card-body">
								
									<form method="post" action="<c:url value='/loginServlet'/>">
										<div class="form-floating mb-3">
											<input class="form-control" id="inputEmail" type="text"
												placeholder="@Account" name="username"value="${username}" />
												 <label
												for="inputEmail">Email address</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="inputPassword"
												type="password" placeholder="Password" value="${password}" name="password"/>
											<label for="inputPassword">Password</label>
										</div>
<!-- 										<div class="form-check mb-3"> -->
<!-- 											<input class="form-check-input" id="inputRememberPassword" -->
<!-- 												type="checkbox" value="" /> <label class="form-check-label" -->
<!-- 												for="inputRememberPassword">Remember Password</label> -->
<!-- 										</div> -->
										<div
											class="d-flex align-items-center justify-content-between mt-4 mb-0">
											<a class="small" href="password.html">Forgot Password?</a>
											<a class="btn btn-primary" onclick="login()">Login</a>
										</div>
									</form>

								</div>
								<div class="card-footer text-center py-3">
									<div class="small">
										<a href="register.html">Need an account? Sign up!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2022</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script>
		function login() {
			document.forms[0].action = "loginServlet";
			document.forms[0].method = "POST";
			document.forms[0].submit();
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="background_index/js/scripts.js"></script>
</body>
</html>
