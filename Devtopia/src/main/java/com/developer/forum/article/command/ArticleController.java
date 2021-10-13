package com.developer.forum.article.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.article.impl.ArticleService;
import com.developer.forum.article.model.ArticleVO;

@Controller
public class ArticleController {
	
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
	
	@RequestMapping(value = "/article/pageNation.do")
	public String pageNationArticleList(Model model, String page) {
		int totalPage = ArticleService.totalPage();
		model.addAttribute("totalPage", totalPage);
		
		List<ArticleVO> articleList = null;
		int startPoint = 0;
		if (page != null) {
			startPoint = Integer.parseInt(page);
		}
		model.addAttribute("ArticleList", startPoint);
		return "article/pageNationArticle";
	}
}
