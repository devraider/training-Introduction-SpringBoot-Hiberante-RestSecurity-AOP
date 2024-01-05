package com.pau.aop;

import com.pau.aop.dao.AccountDAO;
import com.pau.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner-> {
			demoBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
//		accountDAO.addAccount(new Account("Paul", "King"), true);
		accountDAO.getName();
//		accountDAO.setName("Panama");
//		membershipDAO.addAccount();
//		membershipDAO.goToSleep();
	}

}
