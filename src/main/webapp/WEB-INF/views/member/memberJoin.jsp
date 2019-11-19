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
	.btn {
		float: right;
	}
</style>
</head>
<body>
	<c:import url="../layout/nav.jsp"></c:import>
	<div class="container">
		<h2>Member Join Page</h2>
		<br>
		<form id="frm" class="form-horizontal" action="memberJoin" method="post" enctype="multipart/form-data">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">ID:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id"	placeholder="Enter ID" name="id">
				</div>
				<div id="check_id"></div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pw">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pw"	placeholder="Enter Password">
				</div>
				<div id="check_pw"></div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pw2">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pw2" placeholder="Enter Password" name="pw">
				</div>
				<div id="check_pw2"></div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
				</div>
				<div id="check_name"></div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"	placeholder="Enter Email" name="email">
				</div>
				<div id="check_email"></div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="birth">Birth:</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="birth" placeholder="Enter Birth" name="birth">
				</div>
				<div id="check_birth"></div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-10" id="checkbox">
					<input type="radio" value="F" id="gender" name="gender" checked="checked">Female
					<input type="radio" value="M" id="gender" name="gender">Male
				</div>
			</div>
			
			<!-- File -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="file">File:</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" id="file" name="file">
				</div>
				<div id="check_file"></div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" id="join" class="btn btn-info" value="Join">
				</div>
			</div>
			
		</form>
	</div>
	
<script type="text/javascript">
	var joinCheck = false;  //false : 중복된 ID 또는 중복검사를 하지 않은 경우
						  //true : 중복되지 않은 ID
	
	$("#join").click(function() {
		//alert(joinCheck);
		if(joinCheck){
			$("#frm").submit();
		}
	});

	$('#id').blur(function() {
		var id = $(this).val();
		
		if(id!=""){
			$.get("./memberIdCheck?id="+id, function(data) {
				
				data = data.trim();
				
				if(data=='pass'){
					$('#check_id').html("사용가능한 ID입니다.");
					$('#check_id').attr("class", "text-success bg-success");
					joinCheck = true;
				}else {				
					$('#check_id').html("중복된 ID입니다.");
					$('#check_id').attr("class", "text-danger bg-danger");
					joinCheck = false;
					$('#id').val("");
					//$('#id').focus();
				}
			});
		}else {
			$('#check_id').html("ID를 입력해주세요.");
			$('#check_id').attr("class", "text-warning bg-warning");
			joinCheck = false;
			$('#id').val("");
			//$('#id').focus();
		}
	});
	
	
	$('#email').blur(function() {
		var email = $(this).val();
		
	if (email != "") {
			$.post("./memberEmailCheck", {email:email}, function(data) {

				data = data.trim();

				if (data == 'pass') {
					$('#check_email').html("사용가능한 E-mail입니다");
					$('#check_email').attr("class", "text-success bg-success");
					joinCheck = true;
				} else {
					$('#check_email').html("중복된 E-mail입니다.");
					$('#check_email').attr("class", "text-danger bg-danger");
					joinCheck = false;
					$('#email').val("");
				}
			});
		}else{
			$('#check_email').html("E-mail을 입력해주세요.");
			$('#check_email').attr("class", "text-warning bg-warning");
			joinCheck = false;
			$('#email').val("");
		}
	});

	$('#pw').blur(function() {
		if ($(this).val() == "") {
			$('#check_pw').html("Password를 입력해주세요.");
			$('#check_pw').attr("class", "text-warning bg-warning");
			joinCheck = false;
			$('#pw').val("");
		}else{
			$('#check_pw').html("");
		}
	});
	
	$('#pw2').blur(function() {
		if ($(this).val() == "") {
			$('#check_pw2').html("Password를 입력해주세요.");
			$('#check_pw2').attr("class", "text-warning bg-warning");
			joinCheck = false;
			$('#pw2').val("");
		}else{
			$('#check_pw2').html("");
		}
	});
	
	//if($('#pw').val == $('#pw2'))
	
	$('#name').blur(function() {
		if ($(this).val() == "") {
			$('#check_name').html("Name를 입력해주세요.");
			$('#check_name').attr("class", "text-warning bg-warning");
			joinCheck = false;
			$('#name').val("");
		}else{
			$('#check_name').html("");
		}
	});
	
	$('#birth').blur(function() {
		if ($(this).val() == "") {
			$('#check_birth').html("Birth를 입력해주세요.");
			$('#check_birth').attr("class", "text-warning bg-warning");
			joinCheck = false;
			$('#birth').val("");
		}else{
			$('#check_birth').html("");
		}
	});
	
</script>
</body>
</html>