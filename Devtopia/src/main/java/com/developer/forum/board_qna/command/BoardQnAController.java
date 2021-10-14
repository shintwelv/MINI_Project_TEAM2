package com.developer.forum.board_qna.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_news.impl.BoardNewsService;
import com.developer.forum.board_news.model.BoardNewsVO;

@Controller
public class BoardQnAController {
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private BoardNewsService BoardNewsService;
	
	@RequestMapping(value = "/qna/goMain.do")
	public String goMain() {
		return "qna/index";
	}
	
	@RequestMapping(value = "/qna/createArticle.do")
	public String fwdInsertPage() {
		return "qna/createArticle";
	}
	
	@RequestMapping(value = "/qna/createArticleAction.do")
	public String insert(BoardNewsVO vo) {
		BoardNewsService.insert(vo);
		return "qna/createArticleSuccess";
	}
	
	@RequestMapping(value = "/qna/modifyArticle.do")
	public String fwdUpdatePage(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		model.addAttribute("Article", BoardNews);
		return "qna/modifyArticle";
	}
	
	@RequestMapping(value = "/qna/modifyArticleAction.do")
	public String update(BoardNewsVO vo) {
		BoardNewsService.update(vo);
		return "qna/modifyArticleSuccess";
	}
	
	@RequestMapping(value = "/qna/deleteArticle.do")
	public String fwdDeletePage() {
		return "qna/deleteArticle";
	}
	
	@RequestMapping(value = "/qna/selectArticle.do")
	public String select(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		BoardNewsService.countUp(vo);
		model.addAttribute("Article", BoardNews);
		return "qna/selectArticle";
	}
	
	@RequestMapping(value = "/qna/deleteArticleAction.do")
	public String delete(BoardNewsVO vo) {
		BoardNewsService.delete(vo);
		return "qna/deleteArticleSucces";
	}
	
	@RequestMapping(value = "/qna/selectArticleList.do")
	public String selectArticleList(Model model) {
		List<BoardNewsVO> articleList = BoardNewsService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "qna/selectArticleList";
	}
	
	@RequestMapping(value = "/qna/pageNationArticle.do")
	public String fwdpageNationArticleList(Model model) {
		int totalPage = BoardNewsService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardNewsVO> articleList = null;
		articleList = BoardNewsService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "qna/pageNationArticle";
		
	}
	
	@RequestMapping(value = "/qna/pageNationArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		int totalPage = BoardNewsService.totalPage();
		String arrowDirection = request.getParameter("arrowDirection");
		if (arrowDirection != null) {
			if (arrowDirection.trim().equals("left")) {
				calculateLeftArrow();
			} else if (arrowDirection.trim().equals("right")) {
				calculateRightArrow(totalPage);
			}
		}
		String pageNum = request.getParameter("pageNum");
		int pageNumVal = startPoint;
		if (pageNum != null && !pageNum.trim().equals("")) {
			pageNumVal = Integer.parseInt(pageNum);
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardNewsVO> articleList = null;
		articleList = BoardNewsService.pageNationArticleList(pageNumVal);
		model.addAttribute("ArticleList", articleList);
		return "qna/pageNationArticle";
	}
	
	private void calculateLeftArrow() {
		if (startPoint - 5 >= 1) {
			endPoint = startPoint - 1;
			startPoint = startPoint - 5;
		}
	}
	
	private void calculateRightArrow(int totalPage) {
		if (startPoint + 5 <= totalPage) {
			startPoint = startPoint + 5;
		}
		if (endPoint + 5 < totalPage) {
			endPoint = endPoint + 5;
		} else {
			endPoint = totalPage;
		}
	}
	
}
