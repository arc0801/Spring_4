<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="./layout/bootStrap.jsp" />	
</head>
<body>
<c:import url="./layout/nav.jsp" />
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<div id="noticeResult">
		
	</div>
	
	<div>
		<select id="animal">
			<option value="D">Dog</option>
			<option value="C">Cat</option>
			<option value="B">Bird</option>
		</select>
		
		<div id="kind">
			<select>
				<option>치와와</option>
				<option>푸들</option>
				<option>말티즈</option>
			</select>
		</div>
	</div>
	
	<div>
		<input type="text" id="num">
		<button id="btn">Number</button>
	</div>
	
	<div id="result"></div>

<script type="text/javascript">
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP")
	}
	
	xmlhttp.open("GET", "notice/noticeResult");
	xmlhttp.send();

	xmlhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			$('#noticeResult').html(this.responseText);
		}
	}
	
	
	/////////////////////////////////////////////////////////
	$('#animal').change(function() {
		//1. XMLHttpRequest 객체 생성
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp = new XMLHttpRequest();
		}else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP")
		}
		
		//2. 요청 정보 작성		
		xmlhttp.open("GET", "./selectAnimal?kind="+$('#animal').val());
		
		//3. 요청 전송
		//GET
		xmlhttp.send();
		
		//POST
		//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		//xmlhttp.send("파라미터이름=파라미터값&파라미터이름2=파라미터값2");
		
		//4. 결과 처리
		xmlhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				$('#kind').html(this.responseText);
			}
		}
	});
	
	
	
	
	$("#btn").click(function() {
	
		var xmlhttp; //전역변수(script 용어)
	
		if (window.XMLHttpRequest) {
		   // code for modern browsers
		   xmlhttp = new XMLHttpRequest();
		 } else {
		   // code for old IE browsers
		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		var num = $('#num').val();
		
		//request 정보
		xmlhttp.open("POST", "./testAjax", true);
		//xmlhttp.open("GET", "./testAjax?num="+num);
		
		//GET
		//xmlhttp.send();
		
		//POST
		//xmlhttp.send(파라미터);
		
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("num="+num);
		
		xmlhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				//document.getElementById("result").innerHTML = this.responseText; - JS
				$('#result').html(this.responseText); //Jquery
			}
		};
	});
</script>
</body>
</html>
