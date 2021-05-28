package com.tunix.restApp.servlets;

import com.tunix.restApp.model.User;
import com.tunix.restApp.repository.Impl.UserImplRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "User", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private UserImplRepository userRepository = new UserImplRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        List<User> userList = userRepository.getAll();

        resp.setContentType("text/html");
        String title = "Database users";
        String docType = "<!DOCTYPE html>";
        printWriter.println(docType + "<html><head><title>" + title + "</title></head><body>");
        printWriter.println("<h1>USERS DATA</h1>");

        if(req.getParameter("numberOfUser") == null) {
            for (User user : userList) {
                printWriter.println(user);
                printWriter.println("<br/>");
            }
        }else{
            Long id = Long.parseLong(req.getParameter("param"));
            User user = userRepository.getById(id);
            printWriter.println(user);
        }

        printWriter.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("param");
//        userRepository.save(user);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("param"));
        userRepository.deleteById(id);
    }
}
