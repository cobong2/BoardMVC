<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error/error.jsp"%>
<%@ page import="kr.it.psw.*"%>
<%@ page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>) request.getAttribute("data");
%>
<div>
	<%
		if (result.size() == 0) {
	%>
	<p>게시글이 없습니다.</p>
	<%
		} else {
	%>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일시</th>
		</tr>
		<%
			for (BoardVO vo : result) {
		%>
		<tr>
			<td><%=vo.getBid()%></td>
			<td style="width: 500px"><a
				href="boardDetail.bo?bid=<%=vo.getBid()%>&btype=<%=request.getParameter("btype")%>"><%=vo.getBtitle()%></a></td>
			<td><%=vo.getBregdate()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
	<h5>
		<a
			href="http://localhost:8088/BoardMVC/boardRegMod.bo?bid=0&btype=<%=request.getParameter("btype")%>">글쓰기</a>
	</h5>
</div>