package group.G;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public final class gController {

	private AbstractDao dao;

	@Autowired
	public void setDao(AbstractDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/hellow")
	public String hellow() {
		return "hellow";
	}

	@RequestMapping(value={"/","/login"})
	public String login() {
		return "login";
	}

	@RequestMapping("/test")
	public String funny() {
		dao.save(new UserModel("a","b", "c"));
		return "funny";
	}

}