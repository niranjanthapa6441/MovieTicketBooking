package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.CustomExceptions.HallNotFoundException;
import com.example.MovieTicketBooking.CustomExceptions.MovieNotFoundException;
import com.example.MovieTicketBooking.Model.AddMovies;
import com.example.MovieTicketBooking.Model.Hall;
import com.example.MovieTicketBooking.Service.HallService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping
public class HallController {
    private final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }
    @GetMapping("/addHall")
    public String addHallForm(Model model){
        Hall hall= new Hall();
        model.addAttribute("halls",hall);
        model.addAttribute("pageTitle","Add Hall");
        model.addAttribute("button","Add Hall");
        return "AddHall";
    }
    @PostMapping("/addHall")
    public String addHall(@ModelAttribute Hall hall, Model model, @RequestParam("imageFile") MultipartFile multipartFile)
            throws IOException {
        String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
        hall.setImage(fileName);
        String uploadDir="./add-hall/"+hall.getImage();
        Path upload= Paths.get(uploadDir);
        if(!Files.exists(upload)){
            Files.createDirectories(upload);
        }
        try (InputStream inputStream= multipartFile.getInputStream()){
            Path filePath= upload.resolve(fileName);
            Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
            hall.setImagePath(filePath.toString());
        }
        catch(IOException e) {
            throw new IOException("Could not save");
        }
        hallService.addHalls(hall);
        model.addAttribute("halls",hall);
        return "redirect:/allHall";
    }
    @GetMapping("/allHall")
    public String allHallLists(Model model){
        model.addAttribute("halls",hallService.getAllHalls());
        return "displayHalls";
    }
    @GetMapping("/cinemas")
    public String getAllHalls(Model model){
        model.addAttribute("cinema",hallService.getAllHalls());
        return "Cinemas";
    }
    @GetMapping("/updateHall/{id}")
    public String updateMovieForm(@PathVariable String id, Model model, RedirectAttributes redirectAttributes){
        try {
            Hall hall= hallService.get(id);
            model.addAttribute("halls",hall);
            model.addAttribute("pageTitle","Edit Hall");
            model.addAttribute("button","Edit Hall");
        } catch (HallNotFoundException e) {
            e.printStackTrace();
        }
        return "AddHall";
    }
    @GetMapping("/deleteHall/{id}")
    public String deleteMovieForm(@PathVariable String id,Model model,RedirectAttributes redirectAttributes) {
        hallService.deleteMovie(id);
        return "redirect:/allHall";
    }
}
