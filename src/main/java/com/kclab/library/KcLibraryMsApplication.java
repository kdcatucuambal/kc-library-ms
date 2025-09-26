package com.kclab.library;

import com.kclab.library.application.service.observer.BookLendingObserver;
import com.kclab.library.application.service.observer.BookSubject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class KcLibraryMsApplication {


	public static void main(String[] args) {
		SpringApplication.run(KcLibraryMsApplication.class, args);
	}


    @Bean
    public BookSubject bookSubject() {
        var subject = new BookSubject();
        subject.addObserver(new BookLendingObserver());
        return subject;
    }

}
