package co.kr.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.kr.study.domain.Account;

public interface UserRepository  extends JpaRepository<Account, Long>{

}
