<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = (String) request.getAttribute("content");
	name += ".jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박성우 게시판</title>
<link rel="stylesheet" type="text/css" href="jsp/css/common.css">
<link rel="stylesheet" type="text/css" href="jsp/css/boardList.css">
</head>

<body>
	<jsp:include page="top.jsp" />
	<jsp:include page="<%=name%>" />
	<jsp:include page="bottom.jsp" />
</body>
</html>