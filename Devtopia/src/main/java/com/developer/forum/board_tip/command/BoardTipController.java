package com.developer.forum.board_tip.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_tip.impl.BoardTipService;
import com.developer.forum.board_tip.model.BoardTipVO;

@Controller
public class BoardTipController {
	
	@Autowired
	private BoardTipService BoardTipService;
	
//	@RequestMapping(value = {"goMain.do","/"})
//	public String goMain() {
//		return "index";
//	}
	
	@RequestMapping(value = "/createBoardTip.do")
	public String fwdInsertPage() {
		return "createBoardTip";
	}
	
	@RequestMapping(value = "/createBoardTipAction.do")
	public String insert(BoardTipVO vo) {
		BoardTipService.insert(vo);
		return "createBoardTipSuccess";
	}
	
	@RequestMapping(value = "/modifyBoardTip.do")
	public String fwdUpdatePage(BoardTipVO vo, Model model) {
		BoardTipVO BoardTip = BoardTipService.select(vo);
		model.addAttribute("BoardTip", BoardTip);
		return "modifyBoardTip";
	}
	
	@RequestMapping(value = "/modifyBoardTipAction.do")
	public String update(BoardTipVO vo) {
		BoardTipService.update(vo);
		return "modifyBoardTipSuccess";
	}
	
	@RequestMapping(value = "/deleteBoardTip.do")
	public String fwdDeletePage() {
		return "deleteBoardTip";
	}
	
	@RequestMapping(value = "/selectBoardTip.do")
	public String select(BoardTipVO vo, Model model) {
		BoardTipVO BoardTip = BoardTipService.select(vo);
		model.addAttribute("BoardTip", BoardTip);
		return "selectBoardTip";
	}
	
	@RequestMapping(value = "/deleteBoardTipAction.do")
	public String delete(BoardTipVO vo) {
		BoardTipService.delete(vo);
		return "deleteBoardTipSucces";
	}
	
}
