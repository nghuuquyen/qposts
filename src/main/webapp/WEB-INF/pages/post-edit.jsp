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
<link rel="stylesheet" href="/qposts/css/homepage.css" />
<link rel="stylesheet" href="/qposts/css/card-item.css" />

</head>
<body>
	<jsp:include page="./fragments/header.jsp" />

	<!-- page content -->
	<div class="page-wrap">
		<div class="container">
			<h3>${message}</h3>
			<form action="/qposts/post/edit" method="POST">
				<input type="hidden" name="pId" value="${post.id}" /> 
				<input type="text" name="pName" value="${post.name}" /> 
				<input type="text" name="pDescription" value="${post.description}" />
				<textarea rows="4" cols="50" name="pContent">
					${post.content}
				</textarea>
				<input type="submit" value="Do Update" />
			</form>
			<div style="clear: both;"></div>
		</div>
	</div>
	<!-- ./ page content -->

	<jsp:include page="./fragments/footer.jsp" />
</body>
</html>