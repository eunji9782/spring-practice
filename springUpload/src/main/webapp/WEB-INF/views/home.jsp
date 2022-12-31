<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/upload/board/write">게시글 작성</a>

	<br><br><br>
	<hr>
	<br><br><br>
	
	<a download href="/upload/resources/upload/temp.png">이미지 다운로드</a>
	
	<br>
	
	<a href="/upload/board/down">이미지 다운로드(어렵게)</a>
	
	<br>
	
	<a href="/upload/board/download">이미지 다운로드(스프링 권장 방식)</a>
</body>
</html>
