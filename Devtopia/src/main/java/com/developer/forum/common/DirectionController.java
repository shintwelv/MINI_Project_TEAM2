package com.developer.forum.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirectionController {
	
	@RequestMapping(value = {"/", "/goMain.do"})
	public String directionPage() {
		return "direction";
	}
}
