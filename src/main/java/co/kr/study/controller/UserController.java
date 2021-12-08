package co.kr.study.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.kr.study.domain.Account;
import co.kr.study.domain.AccountDto;

@Controller
public class UserController {
	
	
	@GetMapping("/users")
	public String createUser() {
		return "user/login/register";
	}

	@PostMapping("/users")
	public String createUser(AccountDto accountdto) {
		
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.map(accountdto,Account.class);
		
		return "redirect:";
	}
}
