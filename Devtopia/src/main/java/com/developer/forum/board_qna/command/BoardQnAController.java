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
	
//	@RequestMapping(value = {"goMain.do","/"})
//	public String goMain() {
//		return "index";
//	}
	
	@RequestMapping(value = "/createBoardQnA.do")
	public String fwdInsertPage() {
		return "createBoardQnA";
	}
	
	@RequestMapping(value = "/createBoardQnAAction.do")
	public String insert(BoardQnAVO vo) {
		BoardQnAService.insert(vo);
		return "createBoardQnASuccess";
	}
	
	@RequestMapping(value = "/modifyBoardQnA.do")
	public String fwdUpdatePage(BoardQnAVO vo, Model model) {
		BoardQnAVO BoardQnA = BoardQnAService.select(vo);
		model.addAttribute("BoardQnA", BoardQnA);
		return "modifyBoardQnA";
	}
	
	@RequestMapping(value = "/modifyBoardQnAAction.do")
	public String update(BoardQnAVO vo) {
		BoardQnAService.update(vo);
		return "modifyBoardQnASuccess";
	}
	
	@RequestMapping(value = "/deleteBoardQnA.do")
	public String fwdDeletePage() {
		return "deleteBoardQnA";
	}
	
	@RequestMapping(value = "/selectBoardQnA.do")
	public String select(BoardQnAVO vo, Model model) {
		BoardQnAVO BoardQnA = BoardQnAService.select(vo);
		model.addAttribute("BoardQnA", BoardQnA);
		return "selectBoardQnA";
	}
	
	@RequestMapping(value = "/deleteBoardQnAAction.do")
	public String delete(BoardQnAVO vo) {
		BoardQnAService.delete(vo);
		return "deleteBoardQnASucces";
	}
	
}
