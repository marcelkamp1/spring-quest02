package com.wildcodeschool.springquest02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class SpringQuest02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuest02Application.class, args);
	}
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Insert your incarnation number under '/doctor/{yourNumber}";
	}
	
	@RequestMapping("/doctor/{number}")
	@ResponseBody
	public String doc1(@PathVariable int number) {
		if(number <= 0 || number > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + number);
		}
		if(number >= 1 && number <= 8) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER);
		}
		if(number >= 9 && number <= 13) {
			switch(number){
				case 9: return "{\"number\": " + number + ", \"name\": \"Christopher Eccleston\"}";
				case 10: return "{\"number\": " + number + ", \"name\": \"David Tennant\"}";
				case 11: return "{\"number\": " + number + ", \"name\": \"Matt Smith\"}";
				case 12: return "{\"number\": " + number + ", \"name\": \"Peter Capaldi\"}";
				case 13: return "{\"number\": " + number + ", \"name\": \"Jodie Whittaker\"}";
			}
		}
		return "Your number was " + number;
	}

}