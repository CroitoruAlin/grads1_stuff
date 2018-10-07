package training.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletForm extends HttpServlet
{
    List<User> listUsers;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listUsers=new ArrayList<>();
        listUsers.add(new User("Alin","parola"));
        listUsers.add(new User("User1","parola2"));
        System.out.println(req.getParameter("username") + req.getParameter("password"));
        if(listUsers.contains(new User(req.getParameter("username"),req.getParameter("password"))))
            doGet(req,resp);
        else
            resp.getWriter().println("Not a valid user");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/firstPage.jsp").forward(req,resp);
    }
}