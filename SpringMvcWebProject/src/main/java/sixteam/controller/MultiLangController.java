package sixteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiLangController {
	
	@Autowired
	private MessageSource ms;
	
	@GetMapping("/multilang.controller")
	public String processAction() {
		String errMsg = ms.getMessage("program.error", null, LocaleContextHolder.getLocale());
		System.out.println("Locale:" + LocaleContextHolder.getLocale());
		System.out.println("errMsg:" + errMsg);
		return "multilangResult";
	}

}
