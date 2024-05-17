package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import bean.Movie;
import dao.MovieDao;

@Controller
public class MovieController {

    @Autowired
    MovieDao dao; // will inject dao from XML file

    /* Displays a form to input data for adding a new movie */
    @RequestMapping("/movieform")
    public String showForm(Model m) {
        m.addAttribute("command", new Movie());
        return "movieform";
    }

    /* Saves movie data into the database */
    @RequestMapping(value = "/savemovie", method = RequestMethod.POST)
    public String save(@ModelAttribute("movie") Movie movie) {
        dao.save(movie);
        return "redirect:/viewmovies";
    }

    /* Provides a list of movies */
    @RequestMapping("/viewmovies")
    public String viewMovies(Model m) {
        List<Movie> list = dao.getMovies();
        m.addAttribute("list", list);
        return "viewmovies";
    }

    /* Displays movie data in a form for editing based on its id */
    @RequestMapping(value = "/editmovie/{id}")
    public String edit(@PathVariable int id, Model m) {
        Movie movie = dao.getMovieById(id);
        m.addAttribute("command", movie);
        return "movieeditform";
    }

    /* Updates movie data */
    @RequestMapping(value = "/editsavemovie", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("movie") Movie movie) {
        dao.update(movie);
        return "redirect:/viewmovies";
    }

    /* Deletes a movie based on its id */
    @RequestMapping(value = "/deletemovie/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewmovies";
    }
}
