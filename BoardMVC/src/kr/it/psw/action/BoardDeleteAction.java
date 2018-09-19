package kr.it.psw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.psw.*;
import kr.it.psw.common.*;
import kr.it.psw.service.BoardListService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.bo?btype=" + request.getParameter("btype"));
		forward.setRedirect(true);

		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardListService.getDelete(btype, bid);

		if (DBConnector.getConn() != null) {
			System.out.println("연결");
		} else {
			System.out.println("놉");
		}
		return forward;
	}

}
