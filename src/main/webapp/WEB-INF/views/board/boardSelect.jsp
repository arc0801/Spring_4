<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<style type="text/css">
	.contents {
		background-color: lightgray;
		width: 100%;
		height: 200px;
		padding: 20px;
		font-size: 15px;
		margin-bottom: 20px;
	}
</style>
<body>
<c:import url="../layout/nav.jsp" />
	<%-- <h1>${data}</h1> --%>
	
	<div class="container">
		<h2>${board} Select Page</h2>
		<br>
	  <table class="table">
	    <thead>
	      <tr class="info"><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th></tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>${select.title}</td>
	        <td>${select.writer}</td>
	        <td>${select.reg_date}</td>
	        <td>${select.hit}</td>
	      </tr>
	    </tbody>
	  </table>
	  <div class="contents">
		${select.contents}
	  </div>
	  
	  	<a href="${board}Update?num=${select.num}" class="btn btn-info">Update</a>
	 	<a href="${board}Delete?num=${select.num}" class="btn btn-danger">Delete</a>
		<c:catch>
			<c:if test="${board eq 'qna'}">
		 		<a href="${board}Reply?num=${select.num}" class="btn btn-warning">Reply</a>
		 	</c:if>
	 	</c:catch>
		<a href="${board}List" class="btn btn-primary">List</a>
	</div>
	
</body>
</html>