package com.example.mycollections.controllers;

import com.example.mycollections.models.Albums;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final List<Albums> albums = new ArrayList<>() {{
        add(new Albums("Thriller", 1998, "Michael", 4 ));
        add(new Albums("Rye", 1996, "Jhon", 2 ));
        add(new Albums("The Wind", 2004, "Lala", 3 ));
    }};


    @GetMapping("/json")
    public List<Albums> getAlbumsJson() { return albums; }

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumsList = "";

        for(Albums album : albums) {
           albumsList += "<li>" + album + "</li>";
        }

        return """
                   <html>
                       <body>
                           <h1>Albums</h1>
                           <ul>
                   """ +
                    albumsList +
                    """
                            </ul>
                        </body>
                    """;

    }

}
