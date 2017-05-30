package br.com.philippe.controller;

import br.com.philippe.dao.UserDAO;
import br.com.philippe.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by phil on 20/05/17.
 */
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAO userDAO = new UserDAO();
        if (userDAO.isValid(request.getParameter("email"), request.getParameter("password"))) {

            User user = userDAO.getUser();

            // Create session
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("name", user.getName());
            }

            response.sendRedirect("/dashboard");
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
