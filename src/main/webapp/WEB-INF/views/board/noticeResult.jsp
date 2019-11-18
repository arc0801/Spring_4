<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:forEach items="${list}" var="vo">
		<ul>
			<li><a href="notice/noticeSelect?num=${vo.num}">${vo.title}</a></li>
			<li>${vo.reg_date}</li>
		</ul>
	</c:forEach>
	
	
	
	<%-- <div class="container">
		<table class="table">
		    <thead>
		      <tr class="info"><th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th></tr>
		    </thead>
		    <tbody>
				<c:forEach items="${list}" var="dto" begin="0" end="4">
			      <tr>
			        <td>${dto.num}</td>
			        <td>
			        	<c:catch>
			        		<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
			        	</c:catch>
			        	<a href="notice/noticeSelect?num=${dto.num}">${dto.title}</a>
			        </td>
			        <td>${dto.writer}</td>
			        <td>${dto.reg_date}</td>
			        <td>${dto.hit}</td>
			       </tr>
		    	</c:forEach>
		    </tbody>
		  </table>
	</div> --%>
	