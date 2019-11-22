<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
<c:import url="../layout/summernote.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />
	<div class="container">
	  <h2>${board} Reply Form</h2>
	  <form action="${board}Reply" method="post">
	  
	  	<input type="hidden" name="num" value="${num}">
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea class="form-control" id="contents" name="contents"></textarea>
	    </div>
	    
	     <button class="btn btn-info">Submit</button>
	    </form>
	</div>
	
<script type="text/javascript">
	$('#contents').summernote({
		height: 500
	});
</script>
</body>
</html>