package com.msf.ict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controllers")
public class NoteApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(NoteApplication.class, args);
	}
}
