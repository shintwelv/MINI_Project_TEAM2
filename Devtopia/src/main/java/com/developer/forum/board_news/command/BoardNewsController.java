package com.developer.forum.board_news.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_news.impl.BoardNewsService;
import com.developer.forum.board_news.model.BoardNewsVO;
import com.oreilly.servlet.MultipartRequest;

@Controller
public class BoardNewsController {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\Devtopia\\Devtopia\\src\\main\\webapp\\resources\\newsIMG";
	
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private BoardNewsService BoardNewsService;
	
	@RequestMapping(value = "createNewsArticle.do")
	public String fwdInsertPage() {
		return "news/write-article_final";
	}
	
	@RequestMapping(value = "createNewsArticleAction.do")
	public String insert(BoardNewsVO vo, HttpServletRequest request) throws Exception {
		MultipartRequest multipartRequest;
		try {
			multipartRequest = new MultipartRequest(request, CURR_IMAGE_REPO_PATH, 1024*1024*100, "utf-8");
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			String fileName = multipartRequest.getOriginalFileName("imgLoc");
			String writer = multipartRequest.getParameter("writer");
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			vo.setImgLoc("./resources/newsIMG/"+fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(vo);
		BoardNewsService.insert(vo);
		return "news/article-write-success";
	}
	
	@RequestMapping(value = "modifyNewsArticleAction.do")
	public String update(BoardNewsVO vo) {
		BoardNewsService.update(vo);
		return "news/article-update-success";
	}
	
	@RequestMapping(value = "selectNewsArticle.do")
	public String select(BoardNewsVO vo, Model model, HttpServletRequest request) {
		vo.setPostNo(Integer.parseInt(request.getParameter("postNo")));
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		BoardNewsService.countUp(vo);
		model.addAttribute("Article", BoardNews);
		return "news/modify-article_final";
	}
	
	@RequestMapping(value = "deleteNewsArticleAction.do")
	public String delete(BoardNewsVO vo, HttpServletRequest request) {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		vo.setPostNo(postNo);
		BoardNewsService.delete(vo);
		return "news/article-delete-success";
	}
	
	@RequestMapping(value = "pageNationNewsArticle.do")
	public String fwdpageNationArticleList(Model model) {
		List<BoardNewsVO> topFiveList = null;
		topFiveList = BoardNewsService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
		int totalPage = BoardNewsService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardNewsVO> articleList = null;
		articleList = BoardNewsService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "news/board-news_final";
		
	}
	
	@RequestMapping(value = "pageNationNewsArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		List<BoardNewsVO> topFiveList = null;
		topFiveList = BoardNewsService.selectTopFive();
		model.addAttribute("TopFive", topFiveList);
		
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
		return "news/board-news_final";
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
