package kr.it.psw.common;

import static kr.it.psw.common.DBConnector.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.it.psw.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;

	private BoardDAO() { // 생성자
	}

	public static BoardDAO getInstance() { // 싱글톤 패턴
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = " select bid, btitle, to_char(bregdate,'yyyy-mm-dd hh24:mi') as bregdate from t_board" + btype
				+ " order by bid desc ";

		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");

				BoardVO bv = new BoardVO();
				bv.setBid(bid);
				bv.setBtitle(btitle);
				bv.setBregdate(bregdate);
				result.add(bv);
			}
		} catch (SQLException e) {
			// TODO: 예외처리
		} catch (Exception e) {
			// TODO: 예외처리
		} finally {
			close(conn, ps, rs);
		}
		return result;
	}

	public BoardVO getBoardDetail(int btype, int i) {
		BoardVO result = new BoardVO();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = " select bid, btitle, bcontent ,to_char(bregdate,'yyyy-mm-dd hh24:mi') as bregdate from t_board"
				+ btype + " where bid = ? ";
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			ps.setInt(1, i);
			rs = ps.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bregdate = rs.getString("bregdate");

				result.setBid(bid);
				result.setBtitle(btitle);
				result.setBcontent(bcontent);
				result.setBregdate(bregdate);
			}
		} catch (SQLException e) {
			// TODO: 예외처리
		} catch (Exception e) {
			// TODO: 예외처리
		} finally {
			close(conn, ps, rs);
		}
		return result;
	}

	public static int getInsert(int btype, String btitle, String bcontent) {
		int result = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnector.getConn();
			String query = " insert into t_board" + btype
					+ "  (bid, btitle, bcontent) values ((SELECT nvl(MAX(bid), 0)+1 FROM t_board" + btype
					+ " ), ?, ?) ";

			ps = conn.prepareStatement(query);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, null);
		}
		return result;
	}

	public static void getUpdate(int btype, int bid, String btitle, String bcontent) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnector.getConn();
			String query = " update t_board" + btype
					+ "  set btitle = ?, bcontent = ?, bregdate = sysdate where bid = ? ";

			ps = conn.prepareStatement(query);
			ps.setInt(3, bid);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, null);
		}
	}

	public static void getDelete(int btype, int bid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnector.getConn();
			String query = " delete from t_board" + btype + "  where bid = ? ";

			ps = conn.prepareStatement(query);
			ps.setInt(1, bid);
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, null);
		}
	}

	public static int getCount(int btype) {
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnector.getConn();
			String query = " select count(bid) as count from t_board" + btype;

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return count;
	}

	public ArrayList<BoardVO> getPage(int btype, int page) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = String.format(" select * from (select rownum as rnum, z.* from (select * from t_board%d order by bid desc) z where rownum <= %d) where rnum >= %d ",
				btype, page * 10, ((page - 1) * 10) + 1);

		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");

				BoardVO bv = new BoardVO();
				bv.setBid(bid);
				bv.setBtitle(btitle);
				bv.setBregdate(bregdate);
				result.add(bv);
			}
		} catch (SQLException e) {
			// TODO: 예외처리
		} catch (Exception e) {
			// TODO: 예외처리
		} finally {
			close(conn, ps, rs);
		}
		return result;
	}

}