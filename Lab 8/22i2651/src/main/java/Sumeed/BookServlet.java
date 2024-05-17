package Sumeed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 15.99));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Classics", 12.50));
        books.add(new Book("1984", "George Orwell", "Science Fiction", 10.25));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Romance", 8.75));
        
        out.println("<html><head><title>Book List</title></head><body>");
        out.println("<h1>List of Books</h1>");
        out.println("<table border=\"1\"><tr><th>Title</th><th>Author</th><th>Genre</th><th>Price</th></tr>");
        
        for (Book book : books) {
            out.println("<tr><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td>" + book.getGenre() + "</td><td>$" + book.getPrice() + "</td></tr>");
        }
        
        out.println("</table></body></html>");
    }
}
