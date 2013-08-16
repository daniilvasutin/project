package main.java.servletPack;

import main.java.dto.Users;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jahoope1
 * Date: 10.08.13
 * Time: 8:01
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("userName");
        out.println("Hello : " + userName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String userName = req.getParameter("userName");
        String fullName = req.getParameter("fullName");
        String experience = req.getParameter("experience");
        String profession = req.getParameter("profession");

        Users user = new Users();
        user.setUserName(userName);
        user.setFullName(fullName);
        user.setExperience(experience);
        user.setProfession(profession);

        saveToDb(user);

        PrintWriter out = resp.getWriter();
        out.println("<h3>User info</h3>");
        out.println("User name : " + userName + "<br>");
        out.println("Full name : " + fullName + "<br>");
        out.println("Experience : " + experience  + "<br>");
        out.println("Profession : " + profession  + "<br>");

        req.setAttribute("listOfUsers", getListOfUsersFromDb());
        req.getRequestDispatcher("userInfo.jsp").forward(req, resp);
    }

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        org.hibernate.service.ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    private void saveToDb(Users user){

        SessionFactory sessionFactory = configureSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    private List<Users> getListOfUsersFromDb(){

        SessionFactory sessionFactory = configureSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Users");
        List<Users> listOfUsers = query.list();
        session.getTransaction().commit();
        session.close();

        return listOfUsers;
    }
}
