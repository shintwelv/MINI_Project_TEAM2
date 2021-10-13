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
	
	@RequestMapping(value = "/tip/goMain.do")
	public String goMain() {
		return "tip/index";
	}
	
	@RequestMapping(value = "/tip/createBoardTip.do")
	public String fwdInsertPage() {
		return "tip/createBoardTip";
	}
	
	@RequestMapping(value = "/tip/createBoardTipAction.do")
	public String insert(BoardTipVO vo) {
		BoardTipService.insert(vo);
		return "tip/createBoardTipSuccess";
	}
	
	@RequestMapping(value = "/tip/modifyBoardTip.do")
	public String fwdUpdatePage(BoardTipVO vo, Model model) {
		BoardTipVO BoardTip = BoardTipService.select(vo);
		model.addAttribute("BoardTip", BoardTip);
		return "tip/modifyBoardTip";
	}
	
	@RequestMapping(value = "/tip/modifyBoardTipAction.do")
	public String update(BoardTipVO vo) {
		BoardTipService.update(vo);
		return "tip/modifyBoardTipSuccess";
	}
	
	@RequestMapping(value = "/tip/deleteBoardTip.do")
	public String fwdDeletePage() {
		return "tip/deleteBoardTip";
	}
	
	@RequestMapping(value = "/tip/selectBoardTip.do")
	public String select(BoardTipVO vo, Model model) {
		BoardTipVO BoardTip = BoardTipService.select(vo);
		model.addAttribute("BoardTip", BoardTip);
		return "tip/selectBoardTip";
	}
	
	@RequestMapping(value = "/tip/deleteBoardTipAction.do")
	public String delete(BoardTipVO vo) {
		BoardTipService.delete(vo);
		return "tip/deleteBoardTipSucces";
	}
	
}
