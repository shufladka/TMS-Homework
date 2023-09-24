package servlet;

import database.Database;
import domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private final Database database = new Database();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Integer pages = Integer.parseInt(req.getParameter("pages"));
        String author = req.getParameter("author");

        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setPages(pages);
        book.setAuthor(author);

        database.create(book);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}