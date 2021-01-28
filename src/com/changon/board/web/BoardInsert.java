package com.changon.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 작성
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbName(request.getParameter("bName"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		
		int n = dao.insert(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "boardList.do";
		}else {
			String message = "입력 내용 DB 저장하지 못했습니다.";
			request.setAttribute("msg", message);
			viewPage = "views/main/boardInsertFail.jsp";
		}
		
		return viewPage;
	}

}
