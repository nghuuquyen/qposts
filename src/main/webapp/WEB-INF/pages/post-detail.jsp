<%@page import="java.util.List"%>
<%@page import="models.DTO.Post"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${post.name}| Q Posts</title>
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
			<!-- post -->
			<div class="post">
				<!-- post title -->
				<div class="post-title">
					<h1>${post.name}</h1>
					Posted by <a href="https://github.com/nghuuquyen">@nghuuquyen</a>
				</div>
				<!-- ./ post title -->
				<br />
				<!-- post content -->
				<div class="post-content">${post.content}</div>
				<!-- ./ post content -->

				<!-- post author -->
				<div class="post-author">
					<img src="./images/avatar-user.png"></img>
					<h4>
						<a href="#">Nguyễn Hữu Quyền</a>
					</h4>
					<p>Đam mê lập trình, sáng tạo và chia sẽ kiến thức.</p>
				</div>
				<!-- ./ post author -->
			</div>
			<!-- ./ post -->
			<div style="clear: both;"></div>
		</div>
	</div>
	<!-- ./ page content -->

	<jsp:include page="./fragments/footer.jsp" />
</body>
</html>