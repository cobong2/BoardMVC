package kr.it.psw.service;

import java.util.ArrayList;

import kr.it.psw.BoardVO;
import kr.it.psw.common.BoardDAO;

public class BoardListService {
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardList(btype);

		return result;
	}

	public BoardVO getBoardDetail(int btype, int bid) {
		BoardVO result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardDetail(btype, bid);

		return result;
	}

	public static int getInsert(int btype, String btitle, String bcontent) {
		int result = -1;
		result = BoardDAO.getInsert(btype, btitle, bcontent);

		return result;
	}

	public static void getDelete(int btype, int bid) {
		BoardDAO.getDelete(btype, bid);

	}

	public static void getUpdate(int btype, int bid, String btitle, String bcontent) {
		BoardDAO.getUpdate(btype, bid, btitle, bcontent);

	}
}
