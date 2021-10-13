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
	
	@RequestMapping(value = "/job/goMain.do")
	public String goMain() {
		return "job/index";
	}
	
	@RequestMapping(value = "/job/createBoardJob.do")
	public String fwdInsertPage() {
		return "job/createBoardJob";
	}
	
	@RequestMapping(value = "/job/createBoardJobAction.do")
	public String insert(BoardJobVO vo) {
		BoardJobService.insert(vo);
		return "job/createBoardJobSuccess";
	}
	
	@RequestMapping(value = "/job/modifyBoardJob.do")
	public String fwdUpdatePage(BoardJobVO vo, Model model) {
		BoardJobVO BoardJob = BoardJobService.select(vo);
		model.addAttribute("BoardJob", BoardJob);
		return "job/modifyBoardJob";
	}
	
	@RequestMapping(value = "/job/modifyBoardJobAction.do")
	public String update(BoardJobVO vo) {
		BoardJobService.update(vo);
		return "job/modifyBoardJobSuccess";
	}
	
	@RequestMapping(value = "/job/deleteBoardJob.do")
	public String fwdDeletePage() {
		return "job/deleteBoardJob";
	}
	
	@RequestMapping(value = "/job/selectBoardJob.do")
	public String select(BoardJobVO vo, Model model) {
		BoardJobVO BoardJob = BoardJobService.select(vo);
		model.addAttribute("BoardJob", BoardJob);
		return "job/selectBoardJob";
	}
	
	@RequestMapping(value = "/job/deleteBoardJobAction.do")
	public String delete(BoardJobVO vo) {
		BoardJobService.delete(vo);
		return "job/deleteBoardJobSucces";
	}
	
}
