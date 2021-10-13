package com.developer.forum.board_qna.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_qna.impl.BoardQnAService;
import com.developer.forum.board_qna.model.BoardQnAVO;

@Controller
public class BoardQnAController {
	
	@Autowired
	private BoardQnAService BoardQnAService;
	
	@RequestMapping(value = "/qna/goMain.do")
	public String goMain() {
		return "qna/index";
	}
	
	@RequestMapping(value = "/qna/createBoardQnA.do")
	public String fwdInsertPage() {
		return "qna/createBoardQnA";
	}
	
	@RequestMapping(value = "/qna/createBoardQnAAction.do")
	public String insert(BoardQnAVO vo) {
		BoardQnAService.insert(vo);
		return "qna/createBoardQnASuccess";
	}
	
	@RequestMapping(value = "/qna/modifyBoardQnA.do")
	public String fwdUpdatePage(BoardQnAVO vo, Model model) {
		BoardQnAVO BoardQnA = BoardQnAService.select(vo);
		model.addAttribute("BoardQnA", BoardQnA);
		return "qna/modifyBoardQnA";
	}
	
	@RequestMapping(value = "/qna/modifyBoardQnAAction.do")
	public String update(BoardQnAVO vo) {
		BoardQnAService.update(vo);
		return "qna/modifyBoardQnASuccess";
	}
	
	@RequestMapping(value = "/qna/deleteBoardQnA.do")
	public String fwdDeletePage() {
		return "qna/deleteBoardQnA";
	}
	
	@RequestMapping(value = "/qna/selectBoardQnA.do")
	public String select(BoardQnAVO vo, Model model) {
		BoardQnAVO BoardQnA = BoardQnAService.select(vo);
		model.addAttribute("BoardQnA", BoardQnA);
		return "qna/selectBoardQnA";
	}
	
	@RequestMapping(value = "/qna/deleteBoardQnAAction.do")
	public String delete(BoardQnAVO vo) {
		BoardQnAService.delete(vo);
		return "qna/deleteBoardQnASucces";
	}
	
}
