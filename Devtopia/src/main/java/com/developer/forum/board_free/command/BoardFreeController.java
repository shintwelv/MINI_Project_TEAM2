package com.developer.forum.board_free.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_free.impl.BoardFreeService;
import com.developer.forum.board_free.model.BoardFreeVO;

@Controller
public class BoardFreeController {
	
	@Autowired
	private BoardFreeService BoardFreeService;
	
	@RequestMapping(value = "/free/goMain.do")
	public String goMain() {
		return "free/index";
	}
	
	@RequestMapping(value = "/free/createBoardFree.do")
	public String fwdInsertPage() {
		return "free/createArticle";
	}
	
	@RequestMapping(value = "/free/createBoardFreeAction.do")
	public String insert(BoardFreeVO vo) {
		BoardFreeService.insert(vo);
		return "free/createArticleSuccess";
	}
	
	@RequestMapping(value = "/free/modifyBoardFree.do")
	public String fwdUpdatePage(BoardFreeVO vo, Model model) {
		BoardFreeVO BoardFree = BoardFreeService.select(vo);
		model.addAttribute("BoardFree", BoardFree);
		return "free/modifyArticle";
	}
	
	@RequestMapping(value = "/free/modifyBoardFreeAction.do")
	public String update(BoardFreeVO vo) {
		BoardFreeService.update(vo);
		return "free/modifyArticleSuccess";
	}
	
	@RequestMapping(value = "/free/deleteBoardFree.do")
	public String fwdDeletePage() {
		return "free/deleteArticle";
	}
	
	@RequestMapping(value = "/free/selectBoardFree.do")
	public String select(BoardFreeVO vo, Model model) {
		BoardFreeVO BoardFree = BoardFreeService.select(vo);
		model.addAttribute("Article", BoardFree);
		return "free/selectArticle";
	}
	
	@RequestMapping(value = "/free/deleteBoardFreeAction.do")
	public String delete(BoardFreeVO vo) {
		BoardFreeService.delete(vo);
		return "free/deleteArticleSucces";
	}
	
}
