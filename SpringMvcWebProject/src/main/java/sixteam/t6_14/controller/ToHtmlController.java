package sixteam.t6_14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToHtmlController {
	@GetMapping("/toActiveHtml")
	public String toHtml() {
	return "t6_14/mainactive";
	}
}
