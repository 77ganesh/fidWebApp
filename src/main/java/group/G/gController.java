package group.G;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@SessionAttributes("myUser")
public final class gController {

	private AbstractDao dao;

	@Autowired
	public void setDao(AbstractDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value={"/","/login"})
	public String login() {
		return "login";
	}

	@RequestMapping("/auth")
	public @ResponseBody UserModel auth(@RequestBody UserModel t, ModelMap model) {
		// TODO - Avoid bad programming design 
		UserModel tFromDB = dao.findById(t.getId());
		if(tFromDB != null) {
			if (tFromDB.getPass().equals(t.getPass()) == true) {
				model.addAttribute("myUser", tFromDB);
				return tFromDB;
				}
			}
		return null;
	}

	@RequestMapping("/logout")
	public @ResponseBody String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "logout sucess";
	}

	@RequestMapping("/user")
	public @ResponseBody UserModel user(@ModelAttribute("myUser") UserModel t) {
		return t;
	}

	@RequestMapping("/dash")
	public String dash() {
		return "dash";
	}
}