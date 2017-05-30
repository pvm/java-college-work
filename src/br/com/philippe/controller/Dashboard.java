package br.com.philippe.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by phil on 21/05/17.
 */
public class Dashboard extends Base {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Validate Session
        super.validateSession(request, response);

        request.setAttribute("name", "Administrador");
        request.setAttribute("page", "/pages/dashboard.jsp");

        // Dispatch to dashboard
        request.getRequestDispatcher("template.jsp").forward(request, response);
    }
}
