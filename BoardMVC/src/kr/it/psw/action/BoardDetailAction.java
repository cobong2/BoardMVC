package kr.it.psw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.psw.*;
import kr.it.psw.common.*;
import kr.it.psw.service.BoardListService;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);

		BoardListService service = new BoardListService();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardVO data = service.getBoardDetail(btype, bid);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("bid", bid);
		request.setAttribute("content", "boardDetail");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);

		if (DBConnector.getConn() != null) {
			System.out.println("연결");
		} else {
			System.out.println("놉");
		}

		return forward;
	}

}
