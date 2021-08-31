package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.CustomExceptions.MovieNotFoundException;
import com.example.MovieTicketBooking.Model.AddMovies;
import com.example.MovieTicketBooking.Service.AddMovieService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.model.IModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping
public class MovieController {
    private final AddMovieService addMovieService;
    public MovieController(AddMovieService addMovieService) {
        this.addMovieService = addMovieService;
    }
    @GetMapping("")
    public String getHomePage(Model model){
        model.addAttribute("movies",addMovieService.getAllMovies());
        return "index";
    }

    @GetMapping("/addMovie")
    public String showAddMovies(Model model){
        AddMovies addMovies= new AddMovies();
        model.addAttribute("movies",addMovies);
        model.addAttribute("pageTitle","Add New Movie");
        model.addAttribute("button","Add Movie");
        return "addmovie";
    }
    @PostMapping("/addMovie")
    public String registerMovie(@ModelAttribute AddMovies addMovies,Model model,@RequestParam("imageFile") MultipartFile multipartFile,RedirectAttributes redirectAttributes)
            throws IOException {
        String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
        addMovies.setImage(fileName);
        String uploadDir="./saved-movie/"+addMovies.getImage();
        Path upload= Paths.get(uploadDir);
        if(!Files.exists(upload)){
            Files.createDirectories(upload);
        }
        try (InputStream inputStream= multipartFile.getInputStream()){
            Path filePath= upload.resolve(fileName);
            Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
            addMovies.setPathName(filePath.toString());
        }
        catch(IOException e) {
            throw new IOException("Could not save");
        }
        addMovieService.save(addMovies);
        model.addAttribute("movies",addMovies);
        return "redirect:/allMovies";
    }
    @GetMapping("/allMovies")
    public String getAllRooms( Model model){
        model.addAttribute("movies",addMovieService.getAllMovies());
        return "displayMovie";
    }
    @GetMapping("/update/{id}")
    public String updateMovieForm(@PathVariable String id,Model model,RedirectAttributes redirectAttributes){
        try {
            AddMovies addMovies= addMovieService.get(id);
            model.addAttribute("movies",addMovies);
            model.addAttribute("pageTitle","Edit Movie");
            model.addAttribute("button","Edit Movie");
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
        }
        return "addmovie";
    }
    @GetMapping("/delete/{id}")
    public String deleteMovieForm(@PathVariable String id,Model model,RedirectAttributes redirectAttributes) {
        addMovieService.deleteMovie(id);
        return "redirect:/allMovies";
    }
}
