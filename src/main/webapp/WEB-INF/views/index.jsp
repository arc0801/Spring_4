<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="./layout/bootStrap.jsp" />
<c:import url="./layout/summernote.jsp" />
</head>
<body>
<c:import url="./layout/nav.jsp" />
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<div id="editor"></div>

<script type="text/javascript">
	$("#editor").summernote();
</script>
</body>
</html>
