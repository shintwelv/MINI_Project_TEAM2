package com.developer.forum.board_news.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.board_news.impl.BoardNewsService;
import com.developer.forum.board_news.model.BoardNewsVO;

@Controller
public class BoardNewsController {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\Temp\\img";
	
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
		String imgLoc = fileProcess(request);
		vo.setImgLoc(imgLoc);
		System.out.println(imgLoc);
		BoardNewsService.insert(vo);
		return "news/createArticleSuccess";
	}
	
	private String fileProcess(HttpServletRequest request) throws Exception{
		try {
	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	        for (FileItem item : items) {
	        	// Process form file field (input type="file").
	        	if (!item.isFormField()) {
	        		String fieldName = item.getFieldName();
	                String fileName = FilenameUtils.getName(item.getName());
	                InputStream fileContent = item.getInputStream();
	                File newsImg = convertInputStreamToFile(fileContent);
	                if (newsImg != null) {
	    				if(! newsImg.exists()){ //경로상에 파일이 존재하지 않을 경우
	    					if(newsImg.getParentFile().mkdirs()){ //경로에 해당하는 디렉토리들을 생성
	    						newsImg.createNewFile(); //이후 파일 생성
	    					}
	    				}

					}
				}
	        }
	    } catch (FileUploadException e) {
	        throw new ServletException("Cannot parse multipart request.", e);
	    }
	}
	
	private File convertInputStreamToFile(InputStream fileContent) throws IOException {
		File tempFile = File.createTempFile(String.valueOf(fileContent.hashCode()), ".tmp");
	    tempFile.deleteOnExit();

	    copyInputStreamToFile(fileContent, tempFile);

	    return tempFile;
	}

	private void copyInputStreamToFile(InputStream fileContent, File tempFile) throws FileNotFoundException, IOException {
		try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
	        int read;
	        byte[] bytes = new byte[1024];

	        while ((read = fileContent.read(bytes)) != -1) {
	            outputStream.write(bytes, 0, read);
	        }
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
