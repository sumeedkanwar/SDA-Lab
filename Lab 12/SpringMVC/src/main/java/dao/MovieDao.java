package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import bean.Movie;

public class MovieDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Movie movie) {
        String sql = "INSERT INTO Movie (title, rating, director) VALUES (?, ?, ?)";
        return template.update(sql, movie.getTitle(), movie.getRating(), movie.getDirector());
    }

    public int update(Movie movie) {
        String sql = "UPDATE Movie SET title = ?, rating = ?, director = ? WHERE id = ?";
        return template.update(sql, movie.getTitle(), movie.getRating(), movie.getDirector(), movie.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Movie WHERE id = ?";
        return template.update(sql, id);
    }

    public Movie getMovieById(int id) {
        String sql = "SELECT * FROM Movie WHERE id = ?";
        return template.queryForObject(sql, (rs, rowNum) -> mapRowToMovie(rs), id);
    }

    public List<Movie> getMovies() {
        String sql = "SELECT * FROM Movie";
        return template.query(sql, (rs, rowNum) -> mapRowToMovie(rs));
    }

    private Movie mapRowToMovie(ResultSet rs) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getInt("id"));
        movie.setTitle(rs.getString("title"));
        movie.setRating(rs.getFloat("rating"));
        movie.setDirector(rs.getString("director"));
        return movie;
    }
}
