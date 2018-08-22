package com.example.project13;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;
    @RequestMapping("/")
    public String loadData(){

        Actor a = new Actor();
        a.setName("Sandra Bullowski");
        a.setRealname("Sandra Mae Bullowski");
        actorRepository.save(a);

        Movie movie= new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        a.addMovie(movie);
        actorRepository.save(a);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";

    }
}

