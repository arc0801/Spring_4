<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>      
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
	  <h2>${fn:toUpperCase(board)} Update Form</h2>
	  <%-- <h2>${fn:escapeXml('<a href="#">test</a>')}</h2> --%>
	  <form action="${board}Update" method="post" enctype="multipart/form-data">
	  	
	  	<div class="form-group">
	      <input type="hidden" class="form-control" value="${update.num}" id="num" name="num">
	    </div>
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" value="${update.title}" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" value="${update.writer}" readonly="readonly" id="writer" placeholder="Enter Writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea class="form-control" id="contents" name="contents"></textarea>
	    </div>
	    
	    <div>
		    <c:forEach items="${update.files}" var="file" varStatus="st">
		    	<div id="f${file.fnum}">
		    		<p>${file.oname} <input type="button" id="${file.fnum}" value="Del" class="del_file"></p>
		    	</div>
		    </c:forEach>
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
	    </form>
	</div>
	
<script type="text/javascript">
	$('#contents').summernote({
		height: 500
	});
	
	$('#contents').summernote('code', '${update.contents}');
	
	//$('#contents').
	
	var files =$('#files').html(); 
	$('#files').empty();
	//var check = ${size};
	var check = ${fn:length(update.files)};
	
	$('.del_file').click(function() {
		//alert("del");
		//alert(fnum);
		var fnum = $(this).attr("id");
		$.post("./fileDelete", {fnum:fnum}, function(data) {
			alert(data);
			//consol.log;
			data = data.trim();
			if(data == '1'){
				$("#f"+fnum).remove();
				check--;
			}
		});
	})
			
	$('#btn_add').click(function() {
		if(check<5){
			$('#files').append(files);
			check++;
		}else {
			alert("최대 5개까지 가능합니다.")
		}
	});
	
	$('#files').on("click", ".del", function() {
		$(this).parents(".tt").remove();
		check--;
	});
</script>
</body>
</html>