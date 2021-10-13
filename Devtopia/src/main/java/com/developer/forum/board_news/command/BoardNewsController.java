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
	
	@RequestMapping(value = "/news/goMain.do")
	public String goMain() {
		return "news/index";
	}
	
	@RequestMapping(value = "/news/createBoardNews.do")
	public String fwdInsertPage() {
		return "news/createBoardNews";
	}
	
	@RequestMapping(value = "/news/createBoardNewsAction.do")
	public String insert(BoardNewsVO vo) {
		BoardNewsService.insert(vo);
		return "news/createBoardNewsSuccess";
	}
	
	@RequestMapping(value = "/news/modifyBoardNews.do")
	public String fwdUpdatePage(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		model.addAttribute("BoardNews", BoardNews);
		return "news/modifyBoardNews";
	}
	
	@RequestMapping(value = "/news/modifyBoardNewsAction.do")
	public String update(BoardNewsVO vo) {
		BoardNewsService.update(vo);
		return "news/modifyBoardNewsSuccess";
	}
	
	@RequestMapping(value = "/news/deleteBoardNews.do")
	public String fwdDeletePage() {
		return "news/deleteBoardNews";
	}
	
	@RequestMapping(value = "/news/selectBoardNews.do")
	public String select(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		model.addAttribute("BoardNews", BoardNews);
		return "news/selectBoardNews";
	}
	
	@RequestMapping(value = "/news/deleteBoardNewsAction.do")
	public String delete(BoardNewsVO vo) {
		BoardNewsService.delete(vo);
		return "news/deleteBoardNewsSucces";
	}
	
}
