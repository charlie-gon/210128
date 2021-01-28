package com.changon.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardEditComplete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정 완료값 넘겨주는 페이지
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo.setbContent(request.getParameter("bContent"));
		
		dao.update(vo);
		String viewPage = "boardList.do";
		
		return viewPage;
	}

}
