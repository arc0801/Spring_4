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
<body>
<c:import url="../layout/nav.jsp" />
	<div class="container">
		<h2>Member Login Page</h2>
		<br>
		<form class="form-horizontal" action="memberLogin" method="post">

			<div class="form-group">
				<label class="control-label col-sm-2" for="id">ID:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pw">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pw" placeholder="Enter Password" name="pw">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-info" id="login">Login</button>
				</div>
			</div>
			
		</form>
	</div>
</body>
</html>