package br.com.philippe.controller;

import br.com.philippe.dao.StudentDAO;
import br.com.philippe.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by phil on 25/05/17.
 */
public class Students extends Base {

    StudentDAO dao = null;

    public Students() {
        dao = new StudentDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Valida a sessão do usuário
        super.validateSession(request, response);

        String action = request.getParameter("action");
        String page = "/pages/students/list.jsp";
        // Fix pra não usar 15 mil if e else
        action = (action == null) ? "list" : action.toLowerCase();

        switch (action) {
            case "delete":
                dao.delete(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("students", dao.getAll());
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                page = "/pages/students/student.jsp";
                Student student = dao.getById(id);
                request.setAttribute("student", student);
                break;
            case "create":
                page = "/pages/students/student.jsp";
                break;
            default:
                request.setAttribute("students", dao.getAll());
        }

        request.setAttribute("page", page);
        request.getRequestDispatcher("/template.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Valida a sessão do usuário
        super.validateSession(request, response);

        // Pega o id do livro
        String id = request.getParameter("id");

        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setRa(request.getParameter("ra"));
        student.setCourse(request.getParameter("course"));
        student.setPhone(request.getParameter("phone"));

        if (id == null || id.isEmpty()) {
            dao.add(student);
        } else {
            student.setId(Integer.parseInt(id));
            dao.update(student);
        }

        // Define atributos e manda para a listagem
        request.setAttribute("students", dao.getAll());
        request.setAttribute("page", "/pages/students/list.jsp");
        request.getRequestDispatcher("/template.jsp").forward(request, response);
    }
}
