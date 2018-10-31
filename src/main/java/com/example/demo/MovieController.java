package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Repository;



import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class MovieController {

    @Autowired
    UserserviceImpl userservice;

    private final Logger log = Logger.getLogger(MovieController.class.getName());

    @GetMapping ("/")
    public String index(){

        log.info("index called");
        return "index";

    }

    @GetMapping ("/aboutUs")
    public String aboutUs(){

        log.info("aboutUs called");

        return "aboutUs";

    }

    @GetMapping ("/contact")
    public String contact(){

        log.info("contact called");

        return "contact";

    }

    @GetMapping ("/movie")
    public String movie(Model model)throws SQLException {

        List<MovieImpl> movieList = userservice.getMovies();
        model.addAttribute("Movies", movieList);
        //Movies er nøglen

        log.info("movie called");

        return "movie";
    }

    @PostMapping ("/create")
    public String create(@ModelAttribute MovieImpl movie)throws SQLException{


        log.info("create postmapping called");

        userservice.createMovie(movie);


        return "redirect:/movie";
    }

    @GetMapping ("/create")
    public String create(Model model){

        log.info("create called");

        model.addAttribute("movie", new MovieImpl());
        //"movie" er nøglen

        return "create";
    }

    @GetMapping ("/search/{search}")
    public String search (@PathVariable("search") String search, Model model){

        log.info("search was called on: "+search);
        model.addAttribute("searched", userservice.getSearchedByTitle(search));
        // "searched" er nøglen

        return "search";

    }

    @GetMapping ("/select/{selected}")
    public String select (@PathVariable("selected") int selectedId, Model model){

        log.info("Someone selected: "+selectedId);
        model.addAttribute("Selected", userservice.selectMovie(selectedId));
        //NØGLEN er "Selected

        return "select";
    }

    @GetMapping ("/delete/{deleted}")
    public String delete (@PathVariable("deleted") int idForDelete){

        log.info("Thomas has tried to delete: "+idForDelete);
        userservice.deleteMovie(idForDelete);

        return "redirect:/movie";
    }

    @GetMapping ("/update/{id}")
    public String update (@PathVariable int id,  Model model){

        log.info("update called");

        model.addAttribute("update",userservice.selectMovie(id));
        // nøglen er "update"


        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MovieImpl movie)throws SQLException{


        log.info("putmapping has been called");

        userservice.updateMovie(movie);


        return "redirect:/movie";
    }







}
