package com.developer.forum.board_job.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_job.impl.BoardJobService;
import com.developer.forum.board_job.model.BoardJobVO;

@Controller
public class BoardJobController {
	
	@Autowired
	private BoardJobService BoardJobService;
	
	@RequestMapping(value = {"goMain.do","/"})
	public String goMain() {
		return "index";
	}
	
	@RequestMapping(value = "/createBoardJob.do")
	public String fwdInsertPage() {
		return "createBoardJob";
	}
	
	@RequestMapping(value = "/createBoardJobAction.do")
	public String insert(BoardJobVO vo) {
		BoardJobService.insert(vo);
		return "createBoardJobSuccess";
	}
	
	@RequestMapping(value = "/modifyBoardJob.do")
	public String fwdUpdatePage(BoardJobVO vo, Model model) {
		BoardJobVO BoardJob = BoardJobService.select(vo);
		model.addAttribute("BoardJob", BoardJob);
		return "modifyBoardJob";
	}
	
	@RequestMapping(value = "/modifyBoardJobAction.do")
	public String update(BoardJobVO vo) {
		BoardJobService.update(vo);
		return "modifyBoardJobSuccess";
	}
	
	@RequestMapping(value = "/deleteBoardJob.do")
	public String fwdDeletePage() {
		return "deleteBoardJob";
	}
	
	@RequestMapping(value = "/selectBoardJob.do")
	public String select(BoardJobVO vo, Model model) {
		BoardJobVO BoardJob = BoardJobService.select(vo);
		model.addAttribute("BoardJob", BoardJob);
		return "selectBoardJob";
	}
	
	@RequestMapping(value = "/deleteBoardJobAction.do")
	public String delete(BoardJobVO vo) {
		BoardJobService.delete(vo);
		return "deleteBoardJobSucces";
	}
	
}
