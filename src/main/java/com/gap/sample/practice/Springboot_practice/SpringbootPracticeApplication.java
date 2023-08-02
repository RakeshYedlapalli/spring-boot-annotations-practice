package com.gap.sample.practice.Springboot_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
//@EnableConfigServer
public class SpringbootPracticeApplication {


	public static void main(String[] args) {
		System.setProperty("server.port","9454");
		SpringApplication.run(SpringbootPracticeApplication.class, args);
	}

	public void searchColorsWithUserInput(String brandId, String userInput) {
		String colorCode = null;
		StringBuilder desc = new StringBuilder();

		String[] split = userInput.split("\\s+");
		for (String str : split) {
			if(str.matches("[0-9]+")) {
				colorCode = str;
			} else {
				desc = desc.length() == 0 ? desc.append(str) : desc.append(" ").append(str);
			}
		}

		if (colorCode == null || desc.length() == 0) {
			if (colorCode == null) {
				//return searchColorsWithDescription(brandId, userInput);
			} else {
			//	return searchColorsWithColorCode(brandId, colorCode);
			}
		} else {
			//return searchWithColorCodeAndDescription(brandId, colorCode, desc.toString());
		}
	}

}
