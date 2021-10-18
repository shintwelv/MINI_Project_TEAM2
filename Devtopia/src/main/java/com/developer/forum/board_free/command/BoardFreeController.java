package com.developer.forum.board_free.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_free.impl.BoardFreeService;
import com.developer.forum.board_free.model.BoardFreeVO;

@Controller
public class BoardFreeController {
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private BoardFreeService BoardFreeService;
	
	@RequestMapping(value = "goFreeMain.do")
	public String goMain() {
		return "free/index";
	}
	
	@RequestMapping(value = "createFreeArticle.do")
	public String fwdInsertPage() {
		return "free/write-article_final";
	}
	
	@RequestMapping(value = "createFreeArticleAction.do")
	public String insert(BoardFreeVO vo) {
		System.out.println(vo);
		BoardFreeService.insert(vo);
		return "free/writeSuccess";
	}
	
	@RequestMapping(value = "modifyFreeArticle.do")
	public String fwdUpdatePage(BoardFreeVO vo, Model model) {
		BoardFreeVO BoardFree = BoardFreeService.select(vo);
		model.addAttribute("Article", BoardFree);
		return "free/modifyArticle";
	}
	
	@RequestMapping(value = "modifyFreeArticleAction.do")
	public String update(BoardFreeVO vo) {
		System.out.println(vo);
		BoardFreeService.update(vo);
		return "free/writeSuccess";
	}
	
	@RequestMapping(value = "deleteFreeArticle.do")
	public String fwdDeletePage() {
		return "free/deleteArticle";
	}
	
	@RequestMapping(value = "selectFreeArticle.do")
	public String select(BoardFreeVO vo, Model model, HttpServletRequest request) {
		vo.setPostNo(Integer.parseInt(request.getParameter("postNo")));
		BoardFreeVO BoardFree = BoardFreeService.select(vo);
		BoardFreeService.countUp(vo);
		model.addAttribute("Article", BoardFree);
		return "free/modify-article_final";
	}
	
	@RequestMapping(value = "deleteFreeArticleAction.do")
	public String delete(BoardFreeVO vo, HttpServletRequest request) {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		vo.setPostNo(postNo);
		BoardFreeService.delete(vo);
		return "free/writeSuccess";
	}
	
	@RequestMapping(value = "selectFreeArticleList.do")
	public String selectArticleList(Model model) {
		List<BoardFreeVO> articleList = BoardFreeService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "free/selectArticleList";
	}
	
	@RequestMapping(value = "pageNationFreeArticle.do")
	public String fwdpageNationArticleList(Model model) {
		List<BoardFreeVO> topFiveList = null;
		topFiveList = BoardFreeService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
		int totalPage = BoardFreeService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardFreeVO> articleList = null;
		articleList = BoardFreeService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "free/board-free_final";
		
	}
	
	@RequestMapping(value = "pageNationFreeArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		int totalPage = BoardFreeService.totalPage();
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
		
		List<BoardFreeVO> articleList = null;
		articleList = BoardFreeService.pageNationArticleList(pageNumVal);
		model.addAttribute("ArticleList", articleList);
		return "free/board-free_final";
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
