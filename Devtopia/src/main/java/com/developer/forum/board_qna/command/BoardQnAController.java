package com.developer.forum.board_qna.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_qna.impl.BoardQnAService;
import com.developer.forum.board_qna.model.BoardQnAVO;

@Controller
public class BoardQnAController {
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private BoardQnAService BoardQnAService;
	
	@RequestMapping(value = "goQnAMain.do")
	public String goMain() {
		return "qna/index";
	}
	
	@RequestMapping(value = "createQnAArticle.do")
	public String fwdInsertPage() {
		return "qna/createArticle";
	}
	
	@RequestMapping(value = "createQnAArticleAction.do")
	public String insert(BoardQnAVO vo) {
		System.out.println(vo);
		BoardQnAService.insert(vo);
		return "qna/createArticleSuccess";
	}
	
	@RequestMapping(value = "modifyQnAArticle.do")
	public String fwdUpdatePage(BoardQnAVO vo, Model model) {
		BoardQnAVO BoardQnA = BoardQnAService.select(vo);
		model.addAttribute("Article", BoardQnA);
		return "qna/modifyArticle";
	}
	
	@RequestMapping(value = "modifyQnAArticleAction.do")
	public String update(BoardQnAVO vo) {
		BoardQnAService.update(vo);
		return "qna/modifyArticleSuccess";
	}
	
	@RequestMapping(value = "deleteQnAArticle.do")
	public String fwdDeletePage() {
		return "qna/deleteArticle";
	}
	
	@RequestMapping(value = "selectQnAArticle.do")
	public String select(BoardQnAVO vo, Model model) {
		BoardQnAVO BoardQnA = BoardQnAService.select(vo);
		BoardQnAService.countUp(vo);
		model.addAttribute("Article", BoardQnA);
		return "qna/selectArticle";
	}
	
	@RequestMapping(value = "deleteQnAArticleAction.do")
	public String delete(BoardQnAVO vo) {
		BoardQnAService.delete(vo);
		return "qna/deleteArticleSuccess";
	}
	
	@RequestMapping(value = "selectQnAArticleList.do")
	public String selectArticleList(Model model) {
		List<BoardQnAVO> articleList = BoardQnAService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "qna/selectArticleList";
	}
	
	@RequestMapping(value = "pageNationQnAArticle.do")
	public String fwdpageNationArticleList(Model model) {
		List<BoardQnAVO> topFiveList = null;
		topFiveList = BoardQnAService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
		int totalPage = BoardQnAService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardQnAVO> articleList = null;
		articleList = BoardQnAService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "qna/pageNationArticle";
		
	}
	
	@RequestMapping(value = "pageNationQnAArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		int totalPage = BoardQnAService.totalPage();
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
		
		List<BoardQnAVO> articleList = null;
		articleList = BoardQnAService.pageNationArticleList(pageNumVal);
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
