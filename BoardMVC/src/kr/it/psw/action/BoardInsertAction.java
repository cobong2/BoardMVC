package kr.it.psw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.psw.*;
import kr.it.psw.common.*;
import kr.it.psw.service.BoardListService;

public class BoardInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.bo?btype=" + request.getParameter("btype"));
		forward.setRedirect(true);

		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		if (bid == 0) {
			BoardListService.getInsert(btype, btitle, bcontent);
		} else {
			BoardListService.getUpdate(btype, bid, btitle, bcontent);
		}

		if (DBConnector.getConn() != null) {
			System.out.println("연결");
		} else {
			System.out.println("놉");
		}
		return forward;
	}

}
