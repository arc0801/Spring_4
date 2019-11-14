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
	  <h2>${board}</h2>
	  <table class="table">
	    <thead>
	      <tr class="info"><th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th></tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list}" var="dto" varStatus="st">
	    	<!-- mybatis가 알아서 형변환해서 꺼내주기 때문에 따로 형변환 안해줘도 됨 -->
		      <tr>
		        <td>${dto.num}</td>
		        <td>
		        	<c:catch> <!-- try/catch -->
		        	<%-- <c:if test="${board ne 'notice'}"> --%>
		        		<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
		        	<%-- </c:if> --%>
		        	</c:catch>
		        	<a href="${board}Select?num=${dto.num}">${dto.title}</a>
		        </td>
		        <td>${dto.writer}</td>
		        <td>${dto.reg_date}</td>
		        <td>${dto.hit}</td>
		       </tr>
	    	</c:forEach>
	    </tbody>
	  </table>
	  
	  <div class="page_box"> <!-- 페이지번호 박스 -->
		  	<c:if test="${pager.curBlock gt 1}">
		  		<span id="${pager.startNum-1}" class="list">이전</span>
		  	</c:if>	
		  		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		  			<span id="${i}" class="list">${i}</span>
		  		</c:forEach>
		  	<c:if test="${pager.curBlock lt pager.totalBlock }">
		  		<span id="${pager.lastNum+1}" class="list">다음</span>
		  	</c:if>	
	  </div>
	  
	  	<a href="${board}Write" class="btn btn-info">Write</a>
	  	
	  	<div> <!-- 검색창 -->
	  		<form id="frm" action="./${board}List">
	  			<input type="hidden" id="curPage" value="1" name="curPage">
	  			<select name="kind">
	  				<option id="kt" value="kt">Title</option>
	  				<option id="kw" value="kw">Writer</option>
	  				<option id="kc" value="kc">Contents</option>
	  			</select>
	  			
	  			<input type="text" name="search" value="${pager.search}">
	  			<button>Search</button>
	  		</form>
	  	</div>
	  	
	</div>
	<script type="text/javascript">
		var kind = '${pager.kind}';
		if(kind == ''){
			kind = "kt";
		}
		$("#"+kind).prop("selected", true);
		$('.list').click(function() {
			$('#curPage').val($(this).attr('id'));
			$('#frm').submit();
		});
	</script>	
</body>
</html>