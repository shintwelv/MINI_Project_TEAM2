package com.developer.forum.board_tip.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_tip.impl.BoardTipService;
import com.developer.forum.board_tip.model.BoardTipVO;

@Controller
public class BoardTipController {
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private BoardTipService BoardTipService;
	
	@RequestMapping(value = "goTipMain.do")
	public String goMain() {
		return "tip/index";
	}
	
	@RequestMapping(value = "createTipArticle.do")
	public String fwdInsertPage() {
		return "tip/createArticle";
	}
	
	@RequestMapping(value = "createTipArticleAction.do")
	public String insert(BoardTipVO vo) {
		BoardTipService.insert(vo);
		return "tip/createArticleSuccess";
	}
	
	@RequestMapping(value = "modifyTipArticle.do")
	public String fwdUpdatePage(BoardTipVO vo, Model model) {
		BoardTipVO BoardTip = BoardTipService.select(vo);
		model.addAttribute("Article", BoardTip);
		return "tip/modifyArticle";
	}
	
	@RequestMapping(value = "modifyTipArticleAction.do")
	public String update(BoardTipVO vo) {
		BoardTipService.update(vo);
		return "tip/modifyArticleSuccess";
	}
	
	@RequestMapping(value = "deleteTipArticle.do")
	public String fwdDeletePage() {
		return "tip/deleteArticle";
	}
	
	@RequestMapping(value = "selectTipArticle.do")
	public String select(BoardTipVO vo, Model model) {
		BoardTipVO BoardTip = BoardTipService.select(vo);
		BoardTipService.countUp(vo);
		model.addAttribute("Article", BoardTip);
		return "tip/selectArticle";
	}
	
	@RequestMapping(value = "deleteTipArticleAction.do")
	public String delete(BoardTipVO vo) {
		BoardTipService.delete(vo);
		return "tip/deleteArticleSuccess";
	}
	
	@RequestMapping(value = "selectTipArticleList.do")
	public String selectArticleList(Model model) {
		List<BoardTipVO> articleList = BoardTipService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "tip/selectArticleList";
	}
	
	@RequestMapping(value = "pageNationTipArticle.do")
	public String fwdpageNationArticleList(Model model) {
		List<BoardTipVO> topFiveList = null;
		topFiveList = BoardTipService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
		int totalPage = BoardTipService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardTipVO> articleList = null;
		articleList = BoardTipService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "tip/pageNationArticle";
		
	}
	
	@RequestMapping(value = "pageNationTipArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		int totalPage = BoardTipService.totalPage();
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
		
		List<BoardTipVO> articleList = null;
		articleList = BoardTipService.pageNationArticleList(pageNumVal);
		model.addAttribute("ArticleList", articleList);
		return "tip/pageNationArticle";
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
