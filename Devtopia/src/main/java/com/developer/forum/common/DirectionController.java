package com.developer.forum.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_free.impl.BoardFreeService;
import com.developer.forum.board_free.model.BoardFreeVO;
import com.developer.forum.board_news.impl.BoardNewsService;
import com.developer.forum.board_news.model.BoardNewsVO;
import com.developer.forum.board_tip.impl.BoardTipService;
import com.developer.forum.board_tip.model.BoardTipVO;

@Controller
public class DirectionController {
	@Autowired
	BoardFreeService freeService;
	@Autowired
	BoardNewsService newsService;
	@Autowired
	BoardTipService tipService;
	
	
	@RequestMapping(value = {"/", "/goMain.do"})
	public String directionPage(HttpServletRequest request) {
		List<BoardFreeVO> freeArticleList = freeService.selectTopFive();
		List<BoardNewsVO> newsArticleList = newsService.selectTopFive();
		List<BoardTipVO> tipArticleList = tipService.selectTopFive();
		
		request.setAttribute("freeArticleList", freeArticleList);
		request.setAttribute("newsArticleList", newsArticleList);
		request.setAttribute("tipArticleList", tipArticleList);
		
		return "index_final";
	}
}
