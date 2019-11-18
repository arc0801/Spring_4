<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
<style type="text/css">
	#checkbox {
		margin-top: 8px;
	}
	#checkbox input {
		margin-right: 10px;
		vertical-align: -3px;
	}
	#checkbox input:last-child {
		margin-left: 20px;
	}
	#join {
		position: absolute;
		right: 15px;
	}
	#btn {
		float: left;
	}
	#check {
		clear: both;
		margin-left: 18%;
	}
</style>
</head>
<body>
	<c:import url="../layout/nav.jsp"></c:import>
	<div class="container">
		<h2>Member Join Page</h2>
		<br>
		<form class="form-horizontal" action="memberJoin" method="post">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">ID:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id"	placeholder="Enter ID" name="id">
				</div>
				
					<span id="check"></span>
				
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pw">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pw"	placeholder="Enter Password">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pw2">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pw2" placeholder="Enter Password" name="pw">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"	placeholder="Enter Email" name="email">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="birth">Birth:</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="birth" placeholder="Enter Birth" name="birth">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-10" id="checkbox">
					<input type="radio" value="F" id="gender" name="gender">Female
					<input type="radio" value="M" id="gender" name="gender">Male
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-info" value="Join">
				</div>
			</div>
			
		</form>
	</div>
	
<script type="text/javascript">
	var idCheck = false;  //false : 중복된 ID 또는 중복검사를 하지 않은 경우
						  //true : 중복되지 않은 ID
	
	$("#join").click(function() {
		alert();
	});

	$('#id').blur(function() {
		var id = $(this).val();
		
		$.get("./memberIdCheck?id="+id, function(data) {
			
			data = data.trim();
			
			if(data=='pass'){
				$('#check').html("사용가능한 ID입니다.");
				$('#check').attr("class", "text-success bg-success");
				idCheck = true;
			}else {				
				$('#check').html("중복된 ID입니다.");
				$('#check').attr("class", "text-danger bg-danger");
				idCheck = false;
				$('#id').val("");
				$('#id').focus();
			}
		});
	});
</script>
</body>
</html>