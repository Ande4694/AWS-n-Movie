package com.example.demo.Controller;

import com.example.demo.Model.ActorImpl;
import com.example.demo.Model.MovieImpl;
import com.example.demo.Service.UserserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping ("/actors")
    public String actor(Model model){
        log.info("Someone called actors");

        List<ActorImpl> allActors = userservice.GetAllActors();
        model.addAttribute("Actors", allActors);
        // "Actors" er nøglen

        return "actors";
    }

    @GetMapping ("/createActor")
    public String createActor(Model model){

        log.info("Someone is trying to create more actors!! stop them before its too late");

        model.addAttribute("actor", new ActorImpl());

        return "createActor";
    }

    @PostMapping ("/createActor")
    public String createActor(@ModelAttribute ActorImpl actor){

        log.info("AHHH they managed to create another one!! new actor is called: "+actor.getName());

        userservice.createActor(actor);

        return "redirect:/actors";
    }

    @PostMapping ("/create")
    public String create(@ModelAttribute MovieImpl movie){


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

    @GetMapping ("/searchByTitle/{search}")
    public String searchByTitle (@PathVariable("search") String search, Model model){

        log.info("searchByTitle was called on: "+search);
        model.addAttribute("searched", userservice.getSearchedByTitle(search));
        // "searched" er nøglen

        return "searchByTitle";

    }

    @GetMapping ("/searchByGenre/Search={search}")
    public String searchByGenre (@PathVariable ("search") String search, Model model){

        log.info("searchByGenre was called on: "+search);

        model.addAttribute("searched", userservice.getSearchedByGenre(search));
        //"searched" er nøglen

        return "searchByGenre";
    }

    @GetMapping ("/searchActor/Search={search}")
    public String searchActor (@PathVariable("search") String search, Model model){

        log.info("searchActor was called on: "+search);

        model.addAttribute("searched", userservice.getSearchedActor(search));
        // "searched" er nøglen

        return "searchActor";
    }

    @GetMapping ("/select/{selected}")
    public String select (@PathVariable("selected") int selectedId, Model model)throws SQLException{

        log.info("Someone selected: "+selectedId);
        model.addAttribute("Selected", userservice.selectMovie(selectedId));
        //NØGLEN er "Selected

        //model.addAttribute("ActorsIn", userservice.selectMovie(selectedId).getActorsIn());
        // actorsin skal være et array, med inner join, hvor movies = "selectedId"
        model.addAttribute("actorsin", userservice.getActorsIn(selectedId));






        //selectid = selectedId;

        model.addAttribute("selectid", selectedId);






        return "select";
    }

    int selectid;


    @GetMapping ("select/addActor")
    public String addActor ( Model model){

        log.info("someone is trying to connect an actor to movie: "+selectid);

        model.addAttribute("allActors", userservice.getActors());
        //"allActors" er nøglen
        // derfra skal der kunne vælges "add to movie"



        return "addActor";
    }

    @GetMapping ("select/addActor/add/{actorId}")
    public String add(@PathVariable("actorId") int actorIdForAdd ){

        log.info("succesfully added relation between actor: "+actorIdForAdd+" and movie: "+selectid);

        userservice.createRelation(actorIdForAdd, selectid);

        return "redirect:/select/addActor";
    }


    @GetMapping ("/delete/{deleted}")
    public String delete (@PathVariable("deleted") int idForDelete){

        log.info("Thomas has tried to delete: "+idForDelete);
        userservice.deleteMovie(idForDelete);

        return "redirect:/movie";
    }

    @GetMapping ("/deleteActor/{deleted}")
    public String deleteActor (@PathVariable("deleted") int idForTerminate){

        log.info("Someone has terminated actor with id: "+idForTerminate);

        userservice.deleteActor(idForTerminate);

        return "redirect:/actors";
    }

    @GetMapping ("/update/{id}")
    public String update (@PathVariable int id,  Model model){

        log.info("update called");


        model.addAttribute("update",new MovieImpl());
        // nøglen er "update"

        tempid = id;
        log.info("id er nu : "+tempid);

        return "/update";
    }

    int tempid;

    @PostMapping("/update")
    public String update(@ModelAttribute MovieImpl movie)throws SQLException{


        log.info("postmapping has been called");



        userservice.updateMovie(movie, tempid);



        return "redirect:/movie";
    }







}
