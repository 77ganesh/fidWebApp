package group.G;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public final class gController {

	@RequestMapping("/hellow")
	public String hellow() {
		return "hellow";
	}

	@RequestMapping(value={"/","/login"})
	public String login() {
		return "login";
	}

}