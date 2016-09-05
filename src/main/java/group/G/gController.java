package group.G;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
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
	public String funny(ModelMap model) {
		//dao.save(new UserModel("a","b", "c"));
		UserModel t = dao.findById("a");
		//UserModel t = new UserModel("a");
		//dao.delete(t);
		model.addAttribute("t", t.toString());
		return "funny";
	}

}