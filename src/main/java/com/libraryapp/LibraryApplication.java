package com.libraryapp;
import java.time.LocalDate; 
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.libraryapp.entities.Book;
import com.libraryapp.entities.User;
import com.libraryapp.services.BookService;
import com.libraryapp.services.NotificationService;
import com.libraryapp.services.UserService;
import com.libraryapp.utils.MidnightApplicationRefresh;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	BookService bookService;
	
	@Autowired
	UserService usService;
	
	@Autowired
	NotificationService notifService;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	MidnightApplicationRefresh midAppRef;
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
//			User user1 = new User("admin", pwEncoder.encode("admin"), "admin@gmail.com", "Admin", "Admin", "Huizumerlaan 158", "06-11433823", "Amsterdam");
//		      user1.setRole("ROLE_ADMIN");
//		      
//		      User user2 = new User("employee", pwEncoder.encode("employee"), "employee@gamail.com", "Employee", "Employee", "Hugo de Grootstraat 174", "06-87054875", "Sliedrecht");
//		      user2.setRole("ROLE_EMPLOYEE");
//		      
//		      usService.save(user1);
//		      usService.save(user2);

			midAppRef.midnightApplicationRefresher();	
		};
	}
}
