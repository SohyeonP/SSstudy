package co.kr.study.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.study.domain.Account;
import co.kr.study.repository.UserRepository;
import co.kr.study.service.UserService;

@Service("userserivce")
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository userrepository;
	
	
	@Transactional
	@Override
	public void createUser(Account account) {
		
		userrepository.save(account);
	}

}
