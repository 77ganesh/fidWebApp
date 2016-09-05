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
		UserModel t = dao.findById("luffy");
		//UserModel t = new UserModel("a");
		//dao.delete(t);
		model.addAttribute("message", t);
		return "funny";
	}

	@RequestMapping("/tj")
	public @ResponseBody UserModel fun2() {
		UserModel t = new UserModel("robin","batman","pikachu");
		return t;
	}

	@RequestMapping("/auth")
	public @ResponseBody UserModel auth(@RequestBody UserModel t, ModelMap model) {
		// TODO - Avoid bad programming design 
		UserModel tFromDB = dao.findById(t.getId());
		if(tFromDB != null) {
			tFromDB.setPass(null);
			model.addAttribute("myUser", t);
		}
		return tFromDB;
	}

	@RequestMapping("/logout")
	public @ResponseBpdy String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "logout";
	}

	@RequestMapping("/dash")
	public @ResponseBody UserModel 
		dash (@ModelAttribute("myUser") UserModel user) {
		return user;
	}


	// Helper POJO class for sending json responses
	private class gJsonResponse {
		private String status, msg;

		public gJsonResponse(String status, String msg) {
			this.status = status;
			this.msg = msg; 
		}
	}

}