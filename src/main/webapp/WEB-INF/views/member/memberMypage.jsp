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
		<h2>MyPage</h2>
		<br>
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="id">ID:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" value="${member.id}" readonly="readonly" name="id">
				</div>
			</div>
	
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" value="${member.name}" readonly="readonly" name="name">
				</div>
			</div>
	
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" value="${member.email}" readonly="readonly" name="email">
				</div>
			</div>
	
			<div class="form-group">
				<label class="control-label col-sm-2" for="birth">Birth:</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="birth" value="${member.birth}" readonly="readonly" name="birth">
				</div>
			</div>
	
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-10" id="checkbox">
					<input type="radio" id="genderF" onclick="return(false);" name="gender">Female
					<input type="radio" id="genderM" onclick="return(false);" name="gender">Male
				</div>
			</div>
	
			<div class="col-sm-offset-2 col-sm-10">
				<a href="memberUpdate" class="btn btn-info" id="update">Update</a>
				<a href="memberDelete" class="btn btn-danger" id="delete">탈퇴</a>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		if(${member.gender} = 'F'){
			$('#genderF').prop("checked", true)
		}else {
			$('#genderM').prop("checked", true)
		}
	</script>	
</body>
</html>
