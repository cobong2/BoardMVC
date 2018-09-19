package kr.it.psw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.psw.*;
import kr.it.psw.common.*;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);

		request.setAttribute("title", "Main");
		request.setAttribute("content", "main");

		if (DBConnector.getConn() != null) {
			System.out.println("연결");
		} else {
			System.out.println("놉");
		}

		return forward;
	}

}
