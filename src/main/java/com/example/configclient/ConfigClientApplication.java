package com.example.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class ConfigClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}
@RefreshScope
@RestController
class TestRestController{

	@Value("${welcome.message}")
	private String welcomeMessage;

	@RequestMapping(method= RequestMethod.GET,value="welcome" )
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String getMessage() {
		return welcomeMessage;
  }
	

}