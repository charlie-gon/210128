package com.changon.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class ListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		list = dao.selectLsit();
		request.setAttribute("list", list);
		String viewPage = "views/main/boardList.jsp";
		
		return viewPage;
	}

}
