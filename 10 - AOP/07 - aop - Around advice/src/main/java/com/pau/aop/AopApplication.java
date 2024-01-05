package com.pau.aop;

import com.pau.aop.dao.AccountDAO;
import com.pau.aop.dao.MembershipDAO;
import com.pau.aop.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){
		return runner-> {
//			demoBeforeAdvice(accountDAO, membershipDAO);
//			findAccounts(accountDAO);
//			demoAfterThrowing(accountDAO, membershipDAO);
//			demoAfter(accountDAO, membershipDAO);
			demoAround(trafficFortuneService);
		};
	}

	private void demoAround(TrafficFortuneService trafficFortuneService) throws InterruptedException {
		System.out.println("\n\nMain program");
		String s = trafficFortuneService.getFortune(true);
		System.out.println("Fortune is: " + s);
		System.out.println("Finished main!\n\n");
	}

	private void demoAfter(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> accounts = null;

		try {
			accounts = accountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		System.out.println("\n\n This is app \n\n");
	}

	private void demoAfterThrowing(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> accounts = null;

		try {
			accounts = accountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	private void findAccounts(AccountDAO accountDAO) {
		System.out.println(accountDAO.findAccounts(true));
	}
	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
//		accountDAO.addAccount(new Account("Paul", "King"), true);
		accountDAO.getName();
//		accountDAO.setName("Panama");
//		membershipDAO.addAccount();
//		membershipDAO.goToSleep();
	}

}
