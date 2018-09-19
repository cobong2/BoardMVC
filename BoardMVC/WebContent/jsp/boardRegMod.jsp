<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error/error.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<div>
	<form
		action="boardInsert.bo?bid=<%=request.getParameter("bid")%>&btype=<%=request.getParameter("btype")%>"
		method="post">
		제목<input type="text" name="btitle"><br> 내용<br>
		<textarea name="bcontent" rows="8" cols="40"></textarea>
		<br> <input type="submit" name="go" value="전송">
	</form>
</div>