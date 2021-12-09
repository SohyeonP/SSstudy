package co.kr.study.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.kr.study.domain.Account;
import co.kr.study.domain.AccountDto;
import co.kr.study.service.UserService;

@Controller
public class UserController {
	
	
	@GetMapping("/users")
	public String createUser() {
		return "user/login/register";
	}
	
	@Autowired
	private UserService userserivce;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/users")
	public String createUser(AccountDto accountdto) {
		
		ModelMapper modelmapper = new ModelMapper();
		Account account = modelmapper.map(accountdto,Account.class);
	
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		
		userserivce.createUser(account);
		
		return "redirect:/";
	}
}
