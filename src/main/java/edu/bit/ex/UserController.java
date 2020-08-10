package edu.bit.ex;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.UserService;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor
public class UserController {
	
		private UserService userService;
		
		@GetMapping(value="/user/userForm")
		public void  loginForm() {
			log.info("welcome userfform!");
		
			
		}
		
		@PostMapping("/user/addUser")
		public String adduser(UserVO userVO) {
			
			log.info("post handler");
			userService.addUser(userVO);
			
			return "redirect:/";
		}

}
