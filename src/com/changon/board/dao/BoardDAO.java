package com.changon.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.changon.board.common.DAO;
import com.changon.board.vo.BoardVO;

public class BoardDAO extends DAO{
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BoardVO> selectLsit(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		
		String sql = "SELECT * FROM BOARD ORDER BY BID DESC";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BoardVO select(BoardVO vo) {
		// 하나의 데이터 가져오기
		
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				hitCount(vo.getbId()); // 조회수 증가
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(BoardVO vo) {
		int n = 0;
		
		String sql = "INSERT INTO BOARD VALUES(BIDSEQ.NEXTVAL, ?, ?, ?, ?, 0,0,0,0)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			psmt.setDate(4, vo.getbDate());
			n = psmt.executeUpdate();
			
			System.out.println(n + "건 삽입 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(BoardVO vo) {
		int n = 0;
		
		String sql = "DELETE FROM BOARD WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
			
			System.out.println(n + "건 삭제 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	public int update(BoardVO vo) {
		int n = 0;
		String sql = "UPDATE BOARD SET BCONTENT = ? WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n = psmt.executeUpdate();
			
			System.out.println(n + "건 수정 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			// 실행의 반대 순서로 작성
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// hit 숫자 올리는 메소드(조회수 증가 메소드)
	public void hitCount(int hit) {
		String sql = "UPDATE BOARD SET BHIT = BHIT+1 WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hit);
			psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
} // end of class
