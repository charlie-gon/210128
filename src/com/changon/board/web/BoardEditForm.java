package com.changon.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardEditForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 글 수정 boardEditForm.jsp 페이지를 넘긴다.
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("row")));
		vo = dao.select(vo);
		request.setAttribute("vo", vo); // vo를 vo라는 이름으로 실어 보내겠다

		return "views/main/boardEditForm.jsp"; // 실어 보낼 주소
	}

}
