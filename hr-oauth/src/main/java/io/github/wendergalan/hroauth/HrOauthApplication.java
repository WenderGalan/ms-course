package io.github.wendergalan.hroauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HrOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);
	}

}
