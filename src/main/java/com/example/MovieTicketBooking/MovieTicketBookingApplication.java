package com.example.MovieTicketBooking;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MovieTicketBookingApplication {
	@PostConstruct
	public void setup(){
		Stripe.apiKey="sk_test_51JVpymFLT8kGS8MJrh6GyaYo3DSV94cKbgL4awHAUgxPLjI0KL4oBg34mER5n21IP8u3c9cCWD2PjkYE7M1Sw8Vn00QVjiQ02Y";
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApplication.class, args);
	}
	@Bean
	public ViewResolver viewResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode("XHTML");
		templateResolver.setPrefix("views/");
		templateResolver.setSuffix(".html");

		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver);

		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(engine);
		return viewResolver;
	}
}
