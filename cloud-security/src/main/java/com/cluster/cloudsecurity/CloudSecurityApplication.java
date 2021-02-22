package com.cluster.cloudsecurity;

import com.cluster.cloudsecurity.dao.AppUserRepository;
import com.cluster.cloudsecurity.entities.AppRole;
import com.cluster.cloudsecurity.entities.AppUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
// @EnableWebSecurity
public class CloudSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
		return  args -> {
			AppUser user = new AppUser("claude", bCryptPasswordEncoder.encode("pw"));
			user.getRoles().add(new AppRole(null, "USER", null));
			appUserRepository.save(user);
			System.out.println("created user: "+appUserRepository.findAppUserByName("claude").toString());
		};
	}

	@Bean
	BCryptPasswordEncoder getBCEncoder() {
		return new BCryptPasswordEncoder();
	}

}
