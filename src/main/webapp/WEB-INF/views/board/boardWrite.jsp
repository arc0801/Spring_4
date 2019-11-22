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
	      <textarea class="form-control" id="contents" name="contents"></textarea>
	    </div>
	    
	    <div id="files">
		    <div class="form-group tt">
		      <label for="file">File:</label>
		      <br>
		      <div class="col-sm-11">
		     	 <input type="file" class="form-control" id="file" name="file">
		      </div>
		      <div class="col-sm-1">
		     	 <input type="button" class="btn btn-danger del" value="Del">
		      </div>
		    </div>
	    </div>
	    
	    <input type="button" id="btn_add" class="btn btn-success" value="Add File">
	    
	     <button class="btn btn-info">Submit</button>
	     <input type="button" value="test" id="btn">
	    </form>
	</div>
	
<script type="text/javascript">
	
	$('#btn').click(function() {
		alert($('#contents').summernote('code'));
	});

	$('#contents').summernote({
		 height: 300                 // set editor height
		 //minHeight: null,             // set minimum height of editor
		 //maxHeight: null,             // set maximum height of editor
		 //focus: true                  // set focus to editable area after initializing summernote
	});

	$('#contents').summernote('code', 'Hello :)');

	var files = $('#files').html();
	$('#files').empty(); //remove vs empty ; 나 포함 전체 지우기 vs 자식만 지우기
	var check = 0;
	var index = 0; //index 번호
	
	$('#files').on("click", ".del", function() {
		//event.preventDefault();
		//alert("del");
		//$("#files div:last").remove(); //선택된 게 지워지질 않아 ㅜㅠ
		//1. $(this).closest(".tt").remove(); //가장 가까운 거!!
		//2. $(this).parent().parent().remove();
		//3. $(this).parents(".form-group").remove();
		$(this).parentsUntil("#files").remove();
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