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
	
	@RequestMapping(value = {"goMain.do","/"})
	public String goMain() {
		return "index";
	}
	
	@RequestMapping(value = "/createBoardFree.do")
	public String fwdInsertPage() {
		return "createBoardFree";
	}
	
	@RequestMapping(value = "/createBoardFreeAction.do")
	public String insert(BoardFreeVO vo) {
		BoardFreeService.insert(vo);
		return "createBoardFreeSuccess";
	}
	
	@RequestMapping(value = "/modifyBoardFree.do")
	public String fwdUpdatePage(BoardFreeVO vo, Model model) {
		BoardFreeVO BoardFree = BoardFreeService.select(vo);
		model.addAttribute("BoardFree", BoardFree);
		return "modifyBoardFree";
	}
	
	@RequestMapping(value = "/modifyBoardFreeAction.do")
	public String update(BoardFreeVO vo) {
		BoardFreeService.update(vo);
		return "modifyBoardFreeSuccess";
	}
	
	@RequestMapping(value = "/deleteBoardFree.do")
	public String fwdDeletePage() {
		return "deleteBoardFree";
	}
	
	@RequestMapping(value = "/selectBoardFree.do")
	public String select(BoardFreeVO vo, Model model) {
		BoardFreeVO BoardFree = BoardFreeService.select(vo);
		model.addAttribute("BoardFree", BoardFree);
		return "selectBoardFree";
	}
	
	@RequestMapping(value = "/deleteBoardFreeAction.do")
	public String delete(BoardFreeVO vo) {
		BoardFreeService.delete(vo);
		return "deleteBoardFreeSucces";
	}
	
}
