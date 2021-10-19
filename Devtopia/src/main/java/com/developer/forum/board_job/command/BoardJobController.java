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
	
	@RequestMapping(value = "createJobArticle.do")
	public String fwdInsertPage() {
		return "job/write-article_final";
	}
	
	@RequestMapping(value = "createJobArticleAction.do")
	public String insert(BoardJobVO vo) {
		BoardJobService.insert(vo);
		return "job/article-write-success";
	}
	
	@RequestMapping(value = "modifyJobArticleAction.do")
	public String update(BoardJobVO vo) {
		BoardJobService.update(vo);
		return "job/article-update-success";
	}
	
	@RequestMapping(value = "selectJobArticle.do")
	public String select(BoardJobVO vo, Model model, HttpServletRequest request) {
		vo.setPostNo(Integer.parseInt(request.getParameter("postNo")));
		BoardJobVO BoardJob = BoardJobService.select(vo);
		BoardJobService.countUp(vo);
		model.addAttribute("Article", BoardJob);
		return "job/modify-article_final";
	}
	
	@RequestMapping(value = "deleteJobArticleAction.do")
	public String delete(BoardJobVO vo, HttpServletRequest request) {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		vo.setPostNo(postNo);
		BoardJobService.delete(vo);
		return "job/article-delete-success";
	}
	
	@RequestMapping(value = "pageNationJobArticle.do")
	public String fwdpageNationArticleList(Model model) {
		List<BoardJobVO> topFiveList = null;
		topFiveList = BoardJobService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
		int totalPage = BoardJobService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardJobVO> articleList = null;
		articleList = BoardJobService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "job/board-job_final";
		
	}
	
	@RequestMapping(value = "pageNationJobArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		List<BoardJobVO> topFiveList = null;
		topFiveList = BoardJobService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
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
		return "job/board-job_final";
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
