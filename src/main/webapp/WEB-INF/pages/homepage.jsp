<%@page import="java.util.List"%>
<%@page import="models.DTO.Post"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q Posts Home page</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"> 

<link rel="stylesheet" href="css/homepage.css" />
<link rel="stylesheet" href="css/card-item.css" />
</head>
<body>
	<jsp:include page="./fragments/header.jsp" />
	<!-- page content -->
	<div class="page-wrap">
		<div class="container">
			<h1>Top Recent</h1>
			Bởi <a href="/nghuuquyen">Nguyễn Hữu Quyền</a> <br /> <br />

			<!-- card items -->
			<div class="row">
				<c:forEach items="${posts}" var="post">
					<!-- column -->
					<div class="col">
						<!-- card -->
						<div class="qt-card">
							<div class="card-header">
								<img src="images/rain.jpg" />
								<span class="categories">${post.category.name}</span>
							</div>

							<div class="card-body">
								<h3>
									<a href="post?id=${post.id}">${post.name}</a>
								</h3>
								<p>
									<c:out value="${post.description}" />
								</p>
							</div>

							<div class="card-footer">
								<div class="card-statis">
									<a href="#"> <span>25</span> Comments
									</a> <a href="#"> <span>11</span> Likes
									</a>
								</div>
							</div>
						</div>
						<!-- ./ card -->
					</div>
					<!-- ./ column -->
				</c:forEach>
			</div>
			<!-- ./ card items -->

			<div style="clear: both;"></div>
		</div>
	</div>
	<!-- ./ page content -->

	<jsp:include page="./fragments/footer.jsp" />
</body>
</html>