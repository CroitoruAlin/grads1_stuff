package training.servlets;

import training.SessionFactoryProvider;
import training.hotel.HQLHotelData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletAddresses extends HttpServlet {
    SessionFactoryProvider sessionFactoryProvider;

    @Override
    public void init() throws ServletException {
        sessionFactoryProvider=new SessionFactoryProvider("hibernate.cfg.xml");

    }

    @Override
    public void destroy() {
        sessionFactoryProvider.shutdown();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sessionFactoryProvider.getSessionFactory().getCurrentSession().beginTransaction();
        String country=req.getParameter("country");
        System.out.println(country);
        HQLHotelData hotelData=new HQLHotelData(sessionFactoryProvider);
        //List<String> hotels=hotelData.findAllFromCountry(country);
        //for(String hotel:hotels)
          //  resp.getWriter().println("<h1>" + hotel+"</h1>");

    }
}
