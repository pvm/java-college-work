package br.com.philippe.controller;

import br.com.philippe.dao.BookDAO;
import br.com.philippe.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by phil on 21/05/17.
 */
public class Books extends Base {

    private BookDAO dao = null;

    public Books() {
        dao = new BookDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Valida a sessão do usuário
        super.validateSession(request, response);

        String action = request.getParameter("action");
        String page = "/pages/books/list.jsp";
        // Fix pra não usar 15 mil if e else
        action = (action == null) ? "list" : action.toLowerCase();

        switch (action) {
            case "delete":
                dao.delete(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("books", dao.getAll());
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                page = "/pages/books/book.jsp";
                Book book = dao.getById(id);
                request.setAttribute("book", book);
                break;
            case "create":
                page = "/pages/books/book.jsp";
                break;
            default:
                request.setAttribute("books", dao.getAll());
        }

        request.setAttribute("page", page);
        request.getRequestDispatcher("/template.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Valida a sessão do usuário
        super.validateSession(request, response);

        // Pega o id do livro
        String id = request.getParameter("id");

        Book book = new Book();
        book.setName(request.getParameter("name"));
        book.setAuthor(request.getParameter("author"));
        book.setEdition(request.getParameter("edition"));
        book.setPageNumber(Integer.parseInt(request.getParameter("page_number")));

        if (id == null || id.isEmpty()) {
            dao.add(book);
        } else {
            book.setId(Integer.parseInt(id));
            dao.update(book);
        }

        // Define atributos e manda para a listagem
        request.setAttribute("books", dao.getAll());
        request.setAttribute("page", "/pages/books/list.jsp");
        request.getRequestDispatcher("/template.jsp").forward(request, response);
    }
}
