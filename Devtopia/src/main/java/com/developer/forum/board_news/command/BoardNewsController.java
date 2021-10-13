package com.developer.forum.board_news.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_news.impl.BoardNewsService;
import com.developer.forum.board_news.model.BoardNewsVO;

@Controller
public class BoardNewsController {
	
	@Autowired
	private BoardNewsService BoardNewsService;
	
//	@RequestMapping(value = {"goMain.do","/"})
//	public String goMain() {
//		return "index";
//	}
	
	@RequestMapping(value = "/createBoardNews.do")
	public String fwdInsertPage() {
		return "createBoardNews";
	}
	
	@RequestMapping(value = "/createBoardNewsAction.do")
	public String insert(BoardNewsVO vo) {
		BoardNewsService.insert(vo);
		return "createBoardNewsSuccess";
	}
	
	@RequestMapping(value = "/modifyBoardNews.do")
	public String fwdUpdatePage(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		model.addAttribute("BoardNews", BoardNews);
		return "modifyBoardNews";
	}
	
	@RequestMapping(value = "/modifyBoardNewsAction.do")
	public String update(BoardNewsVO vo) {
		BoardNewsService.update(vo);
		return "modifyBoardNewsSuccess";
	}
	
	@RequestMapping(value = "/deleteBoardNews.do")
	public String fwdDeletePage() {
		return "deleteBoardNews";
	}
	
	@RequestMapping(value = "/selectBoardNews.do")
	public String select(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		model.addAttribute("BoardNews", BoardNews);
		return "selectBoardNews";
	}
	
	@RequestMapping(value = "/deleteBoardNewsAction.do")
	public String delete(BoardNewsVO vo) {
		BoardNewsService.delete(vo);
		return "deleteBoardNewsSucces";
	}
	
}
