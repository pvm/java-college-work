package br.com.philippe.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by phil on 21/05/17.
 */
public class Base extends HttpServlet {

    public void validateSession(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);

        if (session == null) {
            try {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
