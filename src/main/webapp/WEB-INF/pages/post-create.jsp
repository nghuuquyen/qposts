<%@page import="java.util.List"%>
<%@page import="models.DTO.Post"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new post | Q Posts</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"> 

<link rel="stylesheet" href="css/homepage.css" />
<link rel="stylesheet" href="css/card-item.css" />
<link rel="stylesheet" href="css/components/form.css" />

</head>
<body>
	<jsp:include page="./fragments/header.jsp" />

	<!-- page content -->
	<div class="page-wrap">
		<div class="container">
			<h1>Create new</h1>
			<hr/>
			<h3>${message}</h3>
			<div class="container">
				<form action="post/create" method="POST">
					<input type="hidden" name="_csrf" value="${_csrf}" />
					<div class="row">
						<div class="col-25">Category</div>
		
						<div class="col-75">
							<select name="cId">
								<c:forEach var="c" items="${categories}">
									<option value="${c.id}">${c.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row">
						<div class="col-25">Post Name</div>

						<div class="col-75">
							<input type="text" name="pName" value="${post.name}" />
						</div>
					</div>
					<div class="row">
						<div class="col-25">Description</div>

						<div class="col-75">
							<input type="text" name="pDescription"
								value="${post.description}" />
						</div>
					</div>
					<div class="row">
						<div class="col-25">Content</div>

						<div class="col-75">
							<textarea rows="4" cols="50" name="pContent"><c:out value="${post.content}" /></textarea>
						</div>
					</div>
					
					<br/>
					<input type="submit" value="Do Create" />
				</form>
			</div>
			
			<div style="clear: both;"></div>
		</div>
	</div>
	<!-- ./ page content -->

	<jsp:include page="./fragments/footer.jsp" />
</body>
</html>