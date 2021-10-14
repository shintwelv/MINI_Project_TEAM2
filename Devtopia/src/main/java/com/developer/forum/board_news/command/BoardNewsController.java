package com.developer.forum.board_news.command;

import java.io.IOException;
import java.util.Enumeration;
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
	private static final String CURR_IMAGE_REPO_PATH = "C:\\Temp\\img\\";
	
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private BoardNewsService BoardNewsService;
	
	@RequestMapping(value = "/news/goMain.do")
	public String goMain() {
		return "news/index";
	}
	
	@RequestMapping(value = "/news/createArticle.do")
	public String fwdInsertPage() {
		return "news/createArticle";
	}
	
	@RequestMapping(value = "/news/createArticleAction.do")
	public String insert(BoardNewsVO vo, HttpServletRequest request) throws Exception {
		MultipartRequest multipartRequest;
		try {
			multipartRequest = new MultipartRequest(request, CURR_IMAGE_REPO_PATH, 1024*1024*100, "utf-8");
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			String fileName = multipartRequest.getOriginalFileName("imgLoc");
			vo.setTitle(title);
			vo.setContent(content);
			vo.setImgLoc(CURR_IMAGE_REPO_PATH+fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(vo);
		BoardNewsService.insert(vo);
		return "news/createArticleSuccess";
	}
	
	private void saveImg(HttpServletRequest request) {
		// input file로 받은 이미지가 지정된 경로에 저장됨(용량 100MB로 제한)
		//C:\Temp\img로 가서 확인
		MultipartRequest multipartRequest;
		try {
			multipartRequest = new MultipartRequest(request, CURR_IMAGE_REPO_PATH, 1024*1024*100, "utf-8");
			Enumeration<String> fileNames = multipartRequest.getFileNames();
			while (fileNames.hasMoreElements()) {
				String fileName = (String) fileNames.nextElement();
				System.out.println(fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/news/modifyArticle.do")
	public String fwdUpdatePage(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		model.addAttribute("Article", BoardNews);
		return "news/modifyArticle";
	}
	
	@RequestMapping(value = "/news/modifyArticleAction.do")
	public String update(BoardNewsVO vo) {
		BoardNewsService.update(vo);
		return "news/modifyArticleSuccess";
	}
	
	@RequestMapping(value = "/news/deleteArticle.do")
	public String fwdDeletePage() {
		return "news/deleteArticle";
	}
	
	@RequestMapping(value = "/news/selectArticle.do")
	public String select(BoardNewsVO vo, Model model) {
		BoardNewsVO BoardNews = BoardNewsService.select(vo);
		BoardNewsService.countUp(vo);
		model.addAttribute("Article", BoardNews);
		return "news/selectArticle";
	}
	
	@RequestMapping(value = "/news/deleteArticleAction.do")
	public String delete(BoardNewsVO vo) {
		BoardNewsService.delete(vo);
		return "news/deleteArticleSucces";
	}
	
	@RequestMapping(value = "/news/selectArticleList.do")
	public String selectArticleList(Model model) {
		List<BoardNewsVO> articleList = BoardNewsService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "news/selectArticleList";
	}
	
	@RequestMapping(value = "/news/pageNationArticle.do")
	public String fwdpageNationArticleList(Model model) {
		int totalPage = BoardNewsService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<BoardNewsVO> articleList = null;
		articleList = BoardNewsService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "news/pageNationArticle";
		
	}
	
	@RequestMapping(value = "/news/pageNationArticleAction.do")
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
		return "news/pageNationArticle";
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
