package com.changon.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.web.BoardDelete;
import com.changon.board.web.BoardEditComplete;
import com.changon.board.web.BoardEditForm;
import com.changon.board.web.BoardForm;
import com.changon.board.web.BoardInsert;
import com.changon.board.web.BoardView;
import com.changon.board.web.ListCommand;
import com.changon.board.web.MainCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>(); // Command.java 인터페이스 + HashMap
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/boardList.do", new ListCommand()); // 게시글 목록
		map.put("/boardForm.do", new BoardForm()); // 글 작성 폼
		map.put("/boardInsert.do", new BoardInsert()); // 글 작성
		map.put("/boardView.do", new BoardView()); // 글상세 보기
		map.put("/boardDelete.do", new BoardDelete()); // 글 삭제
		map.put("/boardEditForm.do", new BoardEditForm()); // 글 수정
		map.put("/boardEditComplete.do", new BoardEditComplete()); // 글 수정 완료값 넘겨주는 페이지
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); // 실제 요청
		
		Command command = map.get(path); // 요청한것을 처리하는 command를 찾아준다.
		String viewPage = command.execute(request, response); // 처리한 후 결과를 돌려줄 page값을 받음
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // viewPage를 실어서 보냄
		dispatcher.forward(request, response);
		
		
	}

}
