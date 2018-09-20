package kr.it.psw.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.psw.*;
import kr.it.psw.common.*;
import kr.it.psw.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);

		int page = 0;
		BoardListService service = new BoardListService();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		page = Utils.getParamInt(request.getParameter("page"));
		if (page != 0) {
		} else {
			page = 1;
		}
		ArrayList<BoardVO> data = service.getPage(btype, page);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("count", ((service.getCount(btype)) / 10) + 1);
		if (DBConnector.getConn() != null) {
			System.out.println("연결");
		} else {
			System.out.println("놉");
		}

		return forward;
	}

}
