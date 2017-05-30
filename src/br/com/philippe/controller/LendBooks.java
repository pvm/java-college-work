package br.com.philippe.controller;

import br.com.philippe.dao.BookDAO;
import br.com.philippe.dao.LoanDAO;
import br.com.philippe.dao.StudentDAO;
import br.com.philippe.dao.UserDAO;
import br.com.philippe.model.Book;
import br.com.philippe.model.Loan;
import br.com.philippe.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by phil on 26/05/17.
 */
public class LendBooks extends Base {

    private LoanDAO dao = null;

    public LendBooks() {
        dao = new LoanDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Valida a sessão do usuário
        super.validateSession(request, response);

        String action = request.getParameter("action");
        String page = "/pages/loans/list.jsp";
        // Fix pra não usar 15 mil if e else
        action = (action == null) ? "list" : action.toLowerCase();

        switch (action) {
            case "returnbook":
                int id = Integer.valueOf(request.getParameter("id"));
                dao.setAsReturned(id);

                request.setAttribute("loans", dao.getAll());
                break;
            case "lend":
                BookDAO bd = new BookDAO();
                StudentDAO sd = new StudentDAO();

                request.setAttribute("books", bd.getAvailables());
                request.setAttribute("students", sd.getAll());
                page = "/pages/loans/loan.jsp";
                break;
            default:
                request.setAttribute("loans", dao.getAll());
                break;
        }

        request.setAttribute("page", page);
        request.getRequestDispatcher("/template.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Valida a sessão do usuário
        super.validateSession(request, response);

        LoanDAO ld = new LoanDAO();
        Book book = (new BookDAO()).getById(Integer.valueOf(request.getParameter("book_id")));
        Student student = (new StudentDAO()).getById(Integer.valueOf(request.getParameter("student_id")));

        Loan loan = new Loan();
        loan.setStudent(student);
        loan.setBook(book);
        loan.setLoanEndDate(request.getParameter("loan_end_date"));
        loan.setLoanStartDate(request.getParameter("loan_start_date"));
        ld.add(loan);

        // Define atributos e manda para a listagem
        request.setAttribute("loans", ld.getAll());
        request.setAttribute("page", "/pages/loans/list.jsp");
        request.getRequestDispatcher("/template.jsp").forward(request, response);
    }
}
