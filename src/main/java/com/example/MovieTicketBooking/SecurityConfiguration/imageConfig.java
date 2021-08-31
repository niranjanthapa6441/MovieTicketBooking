package com.example.MovieTicketBooking.SecurityConfiguration;

import com.example.MovieTicketBooking.Model.AddMovies;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class imageConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadDir= Paths.get("./saved-movie");
        Path upload=Paths.get("./add-hall");
        String movieUpladPath= upload.toFile().getAbsolutePath();
        String movieUploadPath= uploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/saved-movie/**").addResourceLocations("file:/"+movieUploadPath+"/");
        registry.addResourceHandler("/add-hall/**").addResourceLocations("file:/"+movieUpladPath+"/");
    }

}
