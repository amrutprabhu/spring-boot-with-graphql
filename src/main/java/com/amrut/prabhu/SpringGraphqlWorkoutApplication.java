package com.amrut.prabhu;

import com.amrut.prabhu.querydsl.book.Book;
import com.amrut.prabhu.querydsl.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringGraphqlWorkoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlWorkoutApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@EventListener(value = ApplicationReadyEvent.class)
	public void addBooks(){
		Book entity = new Book();
		entity.setId("1");
		entity.setName("amrut");
		bookRepository.save(entity);
	}

}
