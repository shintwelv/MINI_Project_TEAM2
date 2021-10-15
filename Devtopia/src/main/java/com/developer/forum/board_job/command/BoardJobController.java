package com.developer.forum.board_job.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_job.impl.BoardJobService;
import com.developer.forum.board_job.model.BoardJobVO;

@Controller
public class BoardJobController {
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private BoardJobService BoardJobService;
	
	@RequestMapping(value = "/job/goMain.do")
	public String goMain() {
		return "job/index";
	}
	
	@RequestMapping(value = "/job/createArticle.do")
	public String fwdInsertPage() {
		return "job/createArticle";
	}
	
	@RequestMapping(value = "/job/createArticleAction.do")
	public String insert(BoardJobVO vo) {
		BoardJobService.insert(vo);
		return "job/createArticleSuccess";
	}
	
	@RequestMapping(value = "/job/modifyArticle.do")
	public String fwdUpdatePage(BoardJobVO vo, Model model) {
		BoardJobVO BoardJob = BoardJobService.select(vo);
		model.addAttribute("Article", BoardJob);
		return "job/modifyArticle";
	}
	
	@RequestMapping(value = "/job/modifyArticleAction.do")
	public String update(BoardJobVO vo) {
		BoardJobService.update(vo);
		return "job/modifyArticleSuccess";
	}
	
	@RequestMapping(value = "/job/deleteArticle.do")
	public String fwdDeletePage() {
		return "job/deleteArticle";
	}
	
	@RequestMapping(value = "/job/selectArticle.do")
	public String select(BoardJobVO vo, Model model) {
		BoardJobVO BoardJob = BoardJobService.select(vo);
		BoardJobService.countUp(vo);
		model.addAttribute("Article", BoardJob);
		return "job/selectArticle";
	}
	
	@RequestMapping(value = "/job/deleteArticleAction.do")
	public String delete(BoardJobVO vo) {
		BoardJobService.delete(vo);
		return "job/deleteArticleSuccess";
	}
	
	@RequestMapping(value = "/job/selectArticleList.do")
	public String selectArticleList(Model model) {
		List<BoardJobVO> articleList = BoardJobService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "job/selectArticleList";
	}
	
	@RequestMapping(value = "/job/pageNationArticle.do")
	public String fwdpageNationArticleList(Model model) {
		int totalPage = BoardJobService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardJobVO> articleList = null;
		articleList = BoardJobService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "job/pageNationArticle";
		
	}
	
	@RequestMapping(value = "/job/pageNationArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		int totalPage = BoardJobService.totalPage();
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
		
		List<BoardJobVO> articleList = null;
		articleList = BoardJobService.pageNationArticleList(pageNumVal);
		model.addAttribute("ArticleList", articleList);
		return "job/pageNationArticle";
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
