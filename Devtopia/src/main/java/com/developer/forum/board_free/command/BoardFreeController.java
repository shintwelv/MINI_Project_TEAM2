package com.developer.forum.board_free.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.article.model.ArticleVO;
import com.developer.forum.board_free.impl.BoardFreeService;
import com.developer.forum.board_free.model.BoardFreeVO;

@Controller
public class BoardFreeController {
	private int startPoint = 1;
	private int endPoint = 5;
	
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
	
	@RequestMapping(value = "/free/selectArticleList.do")
	public String selectArticleList(Model model) {
		List<ArticleVO> articleList = BoardFreeService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "article/selectArticleList";
	}
	
	@RequestMapping(value = "/free/pageNationArticle.do")
	public String fwdpageNationArticleList(Model model) {
		int totalPage = BoardFreeService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<ArticleVO> articleList = null;
		articleList = BoardFreeService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "article/pageNationArticle";
		
	}
	
	@RequestMapping(value = "/free/pageNationArticleAction.do")
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
		
		List<ArticleVO> articleList = null;
		articleList = BoardFreeService.pageNationArticleList(pageNumVal);
		model.addAttribute("ArticleList", articleList);
		return "article/pageNationArticle";
	}
	
	private void calculateLeftArrow() {
		if (startPoint - 5 >= 1) {
			startPoint = startPoint - 5;
			endPoint = endPoint - 5;
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
