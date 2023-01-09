package sixteam.t6_27.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToJSPController {
	@GetMapping("/ToJSPController")
	public String toHtml() {
		return ("redirect:/t6_27show.controller");
	}
}