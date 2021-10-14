package com.developer.forum.article.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.article.impl.ArticleService;
import com.developer.forum.article.model.ArticleVO;

@Controller
public class ArticleController {
	private int startPoint = 1;
	private int endPoint = 5;
	
	@Autowired
	private ArticleService ArticleService;
	
	@RequestMapping(value = "/article/goMain.do")
	public String goMain() {
		return "article/index";
	}
	
	@RequestMapping(value = "/article/createArticle.do")
	public String fwdInsertPage() {
		return "article/createArticle";
	}
	
	@RequestMapping(value = "/article/createArticleAction.do")
	public String insert(ArticleVO vo) {
		ArticleService.insert(vo);
		return "article/createArticleSuccess";
	}
	
	@RequestMapping(value = "/article/modifyArticle.do")
	public String fwdUpdatePage(ArticleVO vo, Model model) {
		ArticleVO article = ArticleService.select(vo);
		model.addAttribute("Article", article);
		return "article/modifyArticle";
	}
	
	@RequestMapping(value = "/article/modifyArticleAction.do")
	public String update(ArticleVO vo) {
		ArticleService.update(vo);
		return "article/modifyArticleSuccess";
	}
	
	@RequestMapping(value = "/article/deleteArticle.do")
	public String fwdDeletePage() {
		return "article/deleteArticle";
	}
	
	@RequestMapping(value = "/article/selectArticle.do")
	public String select(ArticleVO vo, Model model) {
		ArticleVO Article = ArticleService.select(vo);
		ArticleService.countUp(Article);
		model.addAttribute("Article", Article);
		return "article/selectArticle";
	}
	
	@RequestMapping(value = "/article/deleteArticleAction.do")
	public String delete(ArticleVO vo) {
		ArticleService.delete(vo);
		return "article/deleteArticleSuccess";
	}
	
	@RequestMapping(value = "/article/selectArticleList.do")
	public String selectArticleList(Model model) {
		List<ArticleVO> articleList = ArticleService.selectArticleList();
		model.addAttribute("ArticleList", articleList);
		return "article/selectArticleList";
	}
	
	@RequestMapping(value = "/article/pageNationArticle.do")
	public String fwdpageNationArticleList(Model model) {
		int totalPage = ArticleService.totalPage();
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPoint", startPoint);
		model.addAttribute("endPoint", endPoint);
		
		List<ArticleVO> articleList = null;
		articleList = ArticleService.pageNationArticleList(startPoint);
		model.addAttribute("ArticleList", articleList);
		return "article/pageNationArticle";
		
	}
	
	@RequestMapping(value = "/article/pageNationArticleAction.do")
	public String pageNationArticleList(Model model, HttpServletRequest request) {
		int totalPage = ArticleService.totalPage();
		String arrowDirection = request.getParameter("arrowDirection");
		if (arrowDirection != null) {
			if (arrowDirection.trim().equals("left")) {
				calculateLeftArrow(totalPage);
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
		articleList = ArticleService.pageNationArticleList(pageNumVal);
		model.addAttribute("ArticleList", articleList);
		return "article/pageNationArticle";
	}
	
	private void calculateLeftArrow(int totalPage) {
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
