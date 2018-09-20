package kr.it.psw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.psw.action.Action;
import kr.it.psw.action.BoardDeleteAction;
import kr.it.psw.action.BoardListAction;
import kr.it.psw.action.BoardRegModAction;
import kr.it.psw.action.MainAction;
import kr.it.psw.action.BoardDetailAction;
import kr.it.psw.action.BoardInsertAction;

@WebServlet("*.bo")
public class BoardFrontControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String reqURI = request.getRequestURI(); // 전체주소 다 가져오겠다.
		String ctxPath = request.getContextPath(); // '/'뒤로 안가져오겠다.
		String comd = reqURI.substring(ctxPath.length());
		ActionForward forward = null;
		Action action = null;

		if (comd.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/boardDetail.bo")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/boardDelete.bo")) {
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/boardRegMod.bo")) {
			action = new BoardRegModAction();
			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/boardInsert.bo")) {
			action = new BoardInsertAction();
			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/main.bo")) {
			action = new MainAction();
			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		} else {
			// TODO 없는 주소값 에러페이지 디스플레이 처리
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);

	}

}
