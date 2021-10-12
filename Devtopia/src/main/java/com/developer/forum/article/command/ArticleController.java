package com.developer.forum.article.command;

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
	
	@RequestMapping(value = {"goMain.do","/"})
	public String goMain() {
		return "index";
	}
	
	@RequestMapping(value = "/createArticle.do")
	public String fwdInsertPage() {
		return "createArticle";
	}
	
	@RequestMapping(value = "/createArticleAction.do")
	public String insert(ArticleVO vo) {
		ArticleService.insert(vo);
		return "createArticleSuccess";
	}
	
	@RequestMapping(value = "/modifyArticle.do")
	public String fwdUpdatePage(ArticleVO vo, Model model) {
		ArticleVO article = ArticleService.select(vo);
		model.addAttribute("Article", article);
		return "modifyArticle";
	}
	
	@RequestMapping(value = "/modifyArticleAction.do")
	public String update(ArticleVO vo) {
		ArticleService.update(vo);
		return "modifyArticleSuccess";
	}
	
	@RequestMapping(value = "/deleteArticle.do")
	public String fwdDeletePage() {
		return "deleteArticle";
	}
	
	@RequestMapping(value = "/selectArticle.do")
	public String select(ArticleVO vo, Model model) {
		ArticleVO Article = ArticleService.select(vo);
		model.addAttribute("Article", Article);
		return "selectArticle";
	}
	
	@RequestMapping(value = "/deleteArticleAction.do")
	public String delete(ArticleVO vo) {
		ArticleService.delete(vo);
		return "deleteArticleSucces";
	}
	
}
