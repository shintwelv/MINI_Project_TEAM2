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

	@RequestMapping(value = "createTipArticle.do")
	public String fwdInsertPage() {
		return "tip/write-article_final";
	}
	
	@RequestMapping(value = "createTipArticleAction.do")
	public String insert(BoardTipVO vo) {
		BoardTipService.insert(vo);
		return "tip/article-write-success";
	}
	
	@RequestMapping(value = "modifyTipArticleAction.do")
	public String update(BoardTipVO vo) {
		BoardTipService.update(vo);
		return "tip/article-update-success";
	}
	
	@RequestMapping(value = "selectTipArticle.do")
	public String select(BoardTipVO vo, Model model, HttpServletRequest request) {
		vo.setPostNo(Integer.parseInt(request.getParameter("postNo")));
		BoardTipVO BoardTip = BoardTipService.select(vo);
		BoardTipService.countUp(vo);
		model.addAttribute("Article", BoardTip);
		return "tip/modify-article_final";
	}
	
	@RequestMapping(value = "deleteTipArticleAction.do")
	public String delete(BoardTipVO vo, HttpServletRequest request) {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		vo.setPostNo(postNo);
		BoardTipService.delete(vo);
		return "tip/article-delete-success";
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
		return "tip/board-tip_final";
		
	}
	
	@RequestMapping(value = "pageNationTipArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		List<BoardTipVO> topFiveList = null;
		topFiveList = BoardTipService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
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
		return "tip/board-tip_final";
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
