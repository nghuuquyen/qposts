<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>400 - Page Not Found | Q Posts</title>
<link rel="stylesheet" href="/qposts/css/homepage.css" />
<link rel="stylesheet" href="/qposts/css/card-item.css" />

</head>
<body>
	<jsp:include page="./fragments/header.jsp" />

	<!-- page content -->
	<div class="page-wrap">
		<div class="container">
			<h3>404 - Sorry, that page you looking for seem not exist.</h3>
			<p>${message}</p>
			<div style="clear: both;"></div>
		</div>
	</div>
	<!-- ./ page content -->

	<jsp:include page="./fragments/footer.jsp" />
</body>
</html>