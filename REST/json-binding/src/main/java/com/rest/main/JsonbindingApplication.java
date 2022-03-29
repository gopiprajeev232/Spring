package com.rest.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class JsonbindingApplication {
	public static void main(String[] args) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			Student student = objectMapper.readValue(new File("src/main/data/sample-full.json"), Student.class);

			System.out.print(student);

			System.out.println("Languages: ");
			for(String language : student.getLanguages()) {
				System.out.println(language);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
