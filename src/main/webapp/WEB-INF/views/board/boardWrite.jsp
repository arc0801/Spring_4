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
	  <h2>${board} Write Form</h2>
	  <form action="${board}Write" method="post" enctype="multipart/form-data">
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control del" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea  rows="20" cols="50" class="form-control" id="contents" placeholder="Enter Contents" name="contents"></textarea>
	    </div>
	    
	    <div id="files">
		    <div class="form-group tt">
		      <label for="file">File:</label>
		      <input type="file" class="form-control" id="file" name="file">
		      <input type="button" class="btn btn-danger del" value="Del">
		    </div>
	    </div>
	    
	    <input type="button" id="btn_add" class="btn btn-success" value="Add File">
	    
	     <button class="btn btn-info">Submit</button>
	    </form>
	</div>
	
<script type="text/javascript">
	var files = $('#files').html();
	$('#files').empty(); //remove vs empty ; 나 포함 전체 지우기 vs 자식만 지우기
	var check = 0;
	
	$('#files').on("click", ".del", function() {
		//event.preventDefault();
		//alert("del");
		//$("#files div:last").remove();
		$(this).closest(".tt").remove();
		check--;
	});   //add file은 버튼을 눌러야 추가되는데, 추가되기 전에 이벤트가 실행되므로 이벤트가 실행되지 않는다.
			
	$('#btn_add').click(function() {
		//alert(files);
		if(check<5){
			$('#files').append(files);
			check++;
		}else {
			alert("최대 5개까지 가능합니다.");
		}
	});
	
</script>
</body>
</html>