package com.changon.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새글작성 페이지로 이동
		
			
		return "views/main/boardForm.jsp";
	}

}
