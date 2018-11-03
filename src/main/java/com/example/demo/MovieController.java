package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

        //List<MovieImpl> searched = metode til search
        model.addAttribute("searched", search);
        // "searched" er nøglen

        return "search";

    }




