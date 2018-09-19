<%@ page import="kr.it.psw.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error/error.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardVO vo = (BoardVO) request.getAttribute("data");
%>
<div>
	<table>
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>등록일시</th>
		</tr>
		<tr>
			<td><%=vo.getBid()%></td>
			<td><%=vo.getBtitle()%></td>
			<td><%=vo.getBregdate()%></td>

		</tr>
		<tr>
			<th colspan=3>내용</th>
		</tr>
		<tr>
			<td colspan=3><%=vo.getBcontent()%></td>
		</tr>
	</table>
	<a
		href="boardRegMod.bo?bid=<%=vo.getBid()%>&btype=<%=request.getParameter("btype")%>">수정하기</a>
	<br>
	<form
		action="boardDelete.bo?bid=<%=vo.getBid()%>&btype=<%=request.getParameter("btype")%>"
		method="post">
		<input type="submit" name="delete" value="삭제하기">
	</form>
	<br> <br> <a
		href="boardList.bo?btype=<%=request.getParameter("btype")%>">뒤로가기</a>
</div>